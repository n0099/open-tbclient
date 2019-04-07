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
    private EditText cRX;
    private a cRZ;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> cRY = new HashMap();
    private Map<String, Boolean> cSa = new HashMap(5);
    private Map<String, Boolean> cSb = new HashMap(4);

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
    /* renamed from: lK */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.cSb = map;
    }

    public void q(Map<String, Boolean> map) {
        this.cSa = map;
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
        this.cRZ = aVar;
    }

    public boolean ayb() {
        return ayl();
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
        TextView textView = cVar.cSe;
        EditText editText = cVar.cSf;
        ImageView imageView = cVar.cSg;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.cSp) {
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
                    aVar.ayD();
                }
            });
            this.cRX = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.o.a.Dq()) {
            return;
        }
        cVar.cRW.setBackgroundColor(Color.parseColor("#191919"));
        cVar.cSe.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.cSf.setTextColor(Color.parseColor("#666666"));
        cVar.cSf.setHintTextColor(Color.parseColor("#333333"));
        cVar.cSh.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0266a
    public void az(List<com.baidu.tieba.aiapps.apps.address.c.d> list) {
        if (list != null && list.size() == 3) {
            this.cRX.setTag(d.g.region_province, list.get(0));
            this.cRX.setTag(d.g.region_city, list.get(1));
            this.cRX.setTag(d.g.region_county, list.get(2));
            String aB = com.baidu.tieba.aiapps.apps.address.c.d.aB(list);
            if (this.cRX != null) {
                this.cRX.setText(aB);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cRY;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0264b implements TextWatcher {
        private String cSd;
        private EditText mEditText;

        public C0264b(EditText editText) {
            this.mEditText = editText;
            this.cSd = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.cSd)) {
                    b.this.cSa.put(valueOf, false);
                } else {
                    b.this.cSa.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.cRX == null) {
                        b.this.cRY.put(valueOf, obj);
                    } else {
                        com.baidu.tieba.aiapps.apps.address.c.d lL = b.this.lL(d.g.region_province);
                        if (lL != null) {
                            b.this.cRY.put("l1", lL);
                        }
                        com.baidu.tieba.aiapps.apps.address.c.d lL2 = b.this.lL(d.g.region_city);
                        if (lL2 != null) {
                            b.this.cRY.put("l2", lL2);
                        }
                        b.this.cRY.put("l3", b.this.lL(d.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.cSb.put(valueOf, true);
                    }
                    if (b.this.ayk() && b.this.ayl()) {
                        b.this.cRZ.fN(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.cSb.put(valueOf, false);
                    b.this.cRZ.fN(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayk() {
        for (Boolean bool : this.cSb.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayl() {
        for (Boolean bool : this.cSa.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.aiapps.apps.address.c.d lL(int i) {
        Object tag;
        if (this.cRX == null || (tag = this.cRX.getTag(i)) == null || !(tag instanceof com.baidu.tieba.aiapps.apps.address.c.d)) {
            return null;
        }
        return (com.baidu.tieba.aiapps.apps.address.c.d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View cRW;
        private TextView cSe;
        private EditText cSf;
        private ImageView cSg;
        private View cSh;

        public c(View view) {
            this.cRW = view;
            this.cSe = (TextView) view.findViewById(d.g.delivery_label);
            this.cSf = (EditText) view.findViewById(d.g.delivery_content);
            this.cSg = (ImageView) view.findViewById(d.g.delivery_arrow);
            this.cSh = view.findViewById(d.g.delivery_highlight_line);
        }
    }
}
