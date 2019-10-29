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
import com.baidu.tieba.R;
import com.baidu.tieba.aiapps.apps.address.c.d;
import com.baidu.tieba.aiapps.apps.address.view.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends BaseAdapter implements a.InterfaceC0325a {
    private EditText dnh;
    private a dnj;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> dni = new HashMap();
    private Map<String, Boolean> dnk = new HashMap(5);
    private Map<String, Boolean> dnl = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void gg(boolean z);
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
    /* renamed from: lO */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void q(Map<String, Boolean> map) {
        this.dnl = map;
    }

    public void r(Map<String, Boolean> map) {
        this.dnk = map;
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
        this.dnj = aVar;
    }

    public boolean aFu() {
        return aFE();
    }

    @Override // android.widget.Adapter
    @NonNull
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        c cVar;
        com.baidu.tieba.aiapps.apps.address.c.a item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.delivery_edit_item_layout, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        a(cVar);
        TextView textView = cVar.dno;
        EditText editText = cVar.dnp;
        ImageView imageView = cVar.dnq;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.dnA) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0323b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aFX();
                }
            });
            this.dnh = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.p.a.Kc()) {
            return;
        }
        cVar.dng.setBackgroundColor(Color.parseColor("#191919"));
        cVar.dno.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.dnp.setTextColor(Color.parseColor("#666666"));
        cVar.dnp.setHintTextColor(Color.parseColor("#333333"));
        cVar.dnr.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0325a
    public void aZ(List<d> list) {
        if (list != null && list.size() == 3) {
            this.dnh.setTag(R.id.region_province, list.get(0));
            this.dnh.setTag(R.id.region_city, list.get(1));
            this.dnh.setTag(R.id.region_county, list.get(2));
            String bb = d.bb(list);
            if (this.dnh != null) {
                this.dnh.setText(bb);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dni;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0323b implements TextWatcher {
        private String dnn;
        private EditText mEditText;

        public C0323b(EditText editText) {
            this.mEditText = editText;
            this.dnn = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.dnn)) {
                    b.this.dnk.put(valueOf, false);
                } else {
                    b.this.dnk.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.dnh == null) {
                        b.this.dni.put(valueOf, obj);
                    } else {
                        d lP = b.this.lP(R.id.region_province);
                        if (lP != null) {
                            b.this.dni.put("l1", lP);
                        }
                        d lP2 = b.this.lP(R.id.region_city);
                        if (lP2 != null) {
                            b.this.dni.put("l2", lP2);
                        }
                        b.this.dni.put("l3", b.this.lP(R.id.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.dnl.put(valueOf, true);
                    }
                    if (b.this.aFD() && b.this.aFE()) {
                        b.this.dnj.gg(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.dnl.put(valueOf, false);
                    b.this.dnj.gg(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFD() {
        for (Boolean bool : this.dnl.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFE() {
        for (Boolean bool : this.dnk.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d lP(int i) {
        Object tag;
        if (this.dnh == null || (tag = this.dnh.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View dng;
        private TextView dno;
        private EditText dnp;
        private ImageView dnq;
        private View dnr;

        public c(View view) {
            this.dng = view;
            this.dno = (TextView) view.findViewById(R.id.delivery_label);
            this.dnp = (EditText) view.findViewById(R.id.delivery_content);
            this.dnq = (ImageView) view.findViewById(R.id.delivery_arrow);
            this.dnr = view.findViewById(R.id.delivery_highlight_line);
        }
    }
}
