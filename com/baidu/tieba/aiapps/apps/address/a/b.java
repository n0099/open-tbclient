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
    private EditText dmq;
    private a dms;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> dmr = new HashMap();
    private Map<String, Boolean> dmt = new HashMap(5);
    private Map<String, Boolean> dmu = new HashMap(4);

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
    /* renamed from: lN */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void q(Map<String, Boolean> map) {
        this.dmu = map;
    }

    public void r(Map<String, Boolean> map) {
        this.dmt = map;
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
        this.dms = aVar;
    }

    public boolean aFs() {
        return aFC();
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
        TextView textView = cVar.dmx;
        EditText editText = cVar.dmy;
        ImageView imageView = cVar.dmz;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.dmI) {
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
                    aVar.aFV();
                }
            });
            this.dmq = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.p.a.Kd()) {
            return;
        }
        cVar.dmp.setBackgroundColor(Color.parseColor("#191919"));
        cVar.dmx.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.dmy.setTextColor(Color.parseColor("#666666"));
        cVar.dmy.setHintTextColor(Color.parseColor("#333333"));
        cVar.dmA.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0325a
    public void aZ(List<d> list) {
        if (list != null && list.size() == 3) {
            this.dmq.setTag(R.id.region_province, list.get(0));
            this.dmq.setTag(R.id.region_city, list.get(1));
            this.dmq.setTag(R.id.region_county, list.get(2));
            String bb = d.bb(list);
            if (this.dmq != null) {
                this.dmq.setText(bb);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dmr;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0323b implements TextWatcher {
        private String dmw;
        private EditText mEditText;

        public C0323b(EditText editText) {
            this.mEditText = editText;
            this.dmw = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.dmw)) {
                    b.this.dmt.put(valueOf, false);
                } else {
                    b.this.dmt.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.dmq == null) {
                        b.this.dmr.put(valueOf, obj);
                    } else {
                        d lO = b.this.lO(R.id.region_province);
                        if (lO != null) {
                            b.this.dmr.put("l1", lO);
                        }
                        d lO2 = b.this.lO(R.id.region_city);
                        if (lO2 != null) {
                            b.this.dmr.put("l2", lO2);
                        }
                        b.this.dmr.put("l3", b.this.lO(R.id.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.dmu.put(valueOf, true);
                    }
                    if (b.this.aFB() && b.this.aFC()) {
                        b.this.dms.gg(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.dmu.put(valueOf, false);
                    b.this.dms.gg(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFB() {
        for (Boolean bool : this.dmu.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFC() {
        for (Boolean bool : this.dmt.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d lO(int i) {
        Object tag;
        if (this.dmq == null || (tag = this.dmq.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View dmA;
        private View dmp;
        private TextView dmx;
        private EditText dmy;
        private ImageView dmz;

        public c(View view) {
            this.dmp = view;
            this.dmx = (TextView) view.findViewById(R.id.delivery_label);
            this.dmy = (EditText) view.findViewById(R.id.delivery_content);
            this.dmz = (ImageView) view.findViewById(R.id.delivery_arrow);
            this.dmA = view.findViewById(R.id.delivery_highlight_line);
        }
    }
}
