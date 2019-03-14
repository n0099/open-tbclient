package com.baidu.tieba.aiapps.apps.address.a;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.aiapps.apps.address.view.a;
import com.baidu.tieba.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends BaseAdapter implements a.InterfaceC0266a {
    private EditText cRV;
    private a cRX;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> cRW = new HashMap();
    private Map<String, Boolean> cRY = new HashMap(5);
    private Map<String, Boolean> cRZ = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void fN(boolean z);
    }

    public b(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: lL */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.cRZ = map;
    }

    public void q(Map<String, Boolean> map) {
        this.cRY = map;
    }

    public void setData(List<com.baidu.tieba.aiapps.apps.address.c.a> list) {
        if (list != null) {
            this.mDataList = list;
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public void setDeliveryEditChangedListener(a aVar) {
        this.cRX = aVar;
    }

    public boolean aye() {
        return ayo();
    }

    @Override // android.widget.Adapter
    @NonNull
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        c cVar;
        com.baidu.tieba.aiapps.apps.address.c.a item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(d.h.delivery_edit_item_layout, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        a(cVar);
        TextView textView = cVar.cSc;
        EditText editText = cVar.cSd;
        ImageView imageView = cVar.cSe;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.cSn) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0264b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.ayG();
                }
            });
            this.cRV = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.o.a.Ds()) {
            return;
        }
        cVar.cRU.setBackgroundColor(Color.parseColor("#191919"));
        cVar.cSc.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.cSd.setTextColor(Color.parseColor("#666666"));
        cVar.cSd.setHintTextColor(Color.parseColor("#333333"));
        cVar.cSf.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0266a
    public void az(List<com.baidu.tieba.aiapps.apps.address.c.d> list) {
        if (list != null && list.size() == 3) {
            this.cRV.setTag(d.g.region_province, list.get(0));
            this.cRV.setTag(d.g.region_city, list.get(1));
            this.cRV.setTag(d.g.region_county, list.get(2));
            String aB = com.baidu.tieba.aiapps.apps.address.c.d.aB(list);
            if (this.cRV != null) {
                this.cRV.setText(aB);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cRW;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0264b implements TextWatcher {
        private String cSb;
        private EditText mEditText;

        public C0264b(EditText editText) {
            this.mEditText = editText;
            this.cSb = this.mEditText.getText().toString();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String valueOf = String.valueOf(this.mEditText.getTag());
            if (!TextUtils.isEmpty(valueOf)) {
                if (TextUtils.equals(editable.toString(), this.cSb)) {
                    b.this.cRY.put(valueOf, false);
                } else {
                    b.this.cRY.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.cRV == null) {
                        b.this.cRW.put(valueOf, obj);
                    } else {
                        com.baidu.tieba.aiapps.apps.address.c.d lM = b.this.lM(d.g.region_province);
                        if (lM != null) {
                            b.this.cRW.put("l1", lM);
                        }
                        com.baidu.tieba.aiapps.apps.address.c.d lM2 = b.this.lM(d.g.region_city);
                        if (lM2 != null) {
                            b.this.cRW.put("l2", lM2);
                        }
                        b.this.cRW.put("l3", b.this.lM(d.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.cRZ.put(valueOf, true);
                    }
                    if (b.this.ayn() && b.this.ayo()) {
                        b.this.cRX.fN(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.cRZ.put(valueOf, false);
                    b.this.cRX.fN(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayn() {
        for (Boolean bool : this.cRZ.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayo() {
        for (Boolean bool : this.cRY.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.aiapps.apps.address.c.d lM(int i) {
        Object tag;
        if (this.cRV == null || (tag = this.cRV.getTag(i)) == null || !(tag instanceof com.baidu.tieba.aiapps.apps.address.c.d)) {
            return null;
        }
        return (com.baidu.tieba.aiapps.apps.address.c.d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View cRU;
        private TextView cSc;
        private EditText cSd;
        private ImageView cSe;
        private View cSf;

        public c(View view) {
            this.cRU = view;
            this.cSc = (TextView) view.findViewById(d.g.delivery_label);
            this.cSd = (EditText) view.findViewById(d.g.delivery_content);
            this.cSe = (ImageView) view.findViewById(d.g.delivery_arrow);
            this.cSf = view.findViewById(d.g.delivery_highlight_line);
        }
    }
}
