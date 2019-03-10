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
public class b extends BaseAdapter implements a.InterfaceC0227a {
    private EditText cRZ;
    private a cSb;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> cSa = new HashMap();
    private Map<String, Boolean> cSc = new HashMap(5);
    private Map<String, Boolean> cSd = new HashMap(4);

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
        this.cSd = map;
    }

    public void q(Map<String, Boolean> map) {
        this.cSc = map;
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
        this.cSb = aVar;
    }

    public boolean ayf() {
        return ayp();
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
        TextView textView = cVar.cSg;
        EditText editText = cVar.cSh;
        ImageView imageView = cVar.cSi;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.cSr) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0225b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.ayH();
                }
            });
            this.cRZ = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.o.a.Ds()) {
            return;
        }
        cVar.cRY.setBackgroundColor(Color.parseColor("#191919"));
        cVar.cSg.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.cSh.setTextColor(Color.parseColor("#666666"));
        cVar.cSh.setHintTextColor(Color.parseColor("#333333"));
        cVar.cSj.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0227a
    public void az(List<com.baidu.tieba.aiapps.apps.address.c.d> list) {
        if (list != null && list.size() == 3) {
            this.cRZ.setTag(d.g.region_province, list.get(0));
            this.cRZ.setTag(d.g.region_city, list.get(1));
            this.cRZ.setTag(d.g.region_county, list.get(2));
            String aB = com.baidu.tieba.aiapps.apps.address.c.d.aB(list);
            if (this.cRZ != null) {
                this.cRZ.setText(aB);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.cSa;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0225b implements TextWatcher {
        private String cSf;
        private EditText mEditText;

        public C0225b(EditText editText) {
            this.mEditText = editText;
            this.cSf = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.cSf)) {
                    b.this.cSc.put(valueOf, false);
                } else {
                    b.this.cSc.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.cRZ == null) {
                        b.this.cSa.put(valueOf, obj);
                    } else {
                        com.baidu.tieba.aiapps.apps.address.c.d lM = b.this.lM(d.g.region_province);
                        if (lM != null) {
                            b.this.cSa.put("l1", lM);
                        }
                        com.baidu.tieba.aiapps.apps.address.c.d lM2 = b.this.lM(d.g.region_city);
                        if (lM2 != null) {
                            b.this.cSa.put("l2", lM2);
                        }
                        b.this.cSa.put("l3", b.this.lM(d.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.cSd.put(valueOf, true);
                    }
                    if (b.this.ayo() && b.this.ayp()) {
                        b.this.cSb.fN(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.cSd.put(valueOf, false);
                    b.this.cSb.fN(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayo() {
        for (Boolean bool : this.cSd.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayp() {
        for (Boolean bool : this.cSc.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tieba.aiapps.apps.address.c.d lM(int i) {
        Object tag;
        if (this.cRZ == null || (tag = this.cRZ.getTag(i)) == null || !(tag instanceof com.baidu.tieba.aiapps.apps.address.c.d)) {
            return null;
        }
        return (com.baidu.tieba.aiapps.apps.address.c.d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View cRY;
        private TextView cSg;
        private EditText cSh;
        private ImageView cSi;
        private View cSj;

        public c(View view) {
            this.cRY = view;
            this.cSg = (TextView) view.findViewById(d.g.delivery_label);
            this.cSh = (EditText) view.findViewById(d.g.delivery_content);
            this.cSi = (ImageView) view.findViewById(d.g.delivery_arrow);
            this.cSj = view.findViewById(d.g.delivery_highlight_line);
        }
    }
}
