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
public class b extends BaseAdapter implements a.InterfaceC0281a {
    private EditText dar;
    private a dau;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> das = new HashMap();
    private Map<String, Boolean> dav = new HashMap(5);
    private Map<String, Boolean> daw = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void gk(boolean z);
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
    /* renamed from: mx */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.daw = map;
    }

    public void q(Map<String, Boolean> map) {
        this.dav = map;
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
        this.dau = aVar;
    }

    public boolean aDj() {
        return aDt();
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
        TextView textView = cVar.daA;
        EditText editText = cVar.daB;
        ImageView imageView = cVar.daC;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.daL) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0279b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aDL();
                }
            });
            this.dar = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.q.a.Ev()) {
            return;
        }
        cVar.daq.setBackgroundColor(Color.parseColor("#191919"));
        cVar.daA.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.daB.setTextColor(Color.parseColor("#666666"));
        cVar.daB.setHintTextColor(Color.parseColor("#333333"));
        cVar.daD.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0281a
    public void aG(List<d> list) {
        if (list != null && list.size() == 3) {
            this.dar.setTag(R.id.region_province, list.get(0));
            this.dar.setTag(R.id.region_city, list.get(1));
            this.dar.setTag(R.id.region_county, list.get(2));
            String aI = d.aI(list);
            if (this.dar != null) {
                this.dar.setText(aI);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.das;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0279b implements TextWatcher {
        private String daz;
        private EditText mEditText;

        public C0279b(EditText editText) {
            this.mEditText = editText;
            this.daz = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.daz)) {
                    b.this.dav.put(valueOf, false);
                } else {
                    b.this.dav.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.dar == null) {
                        b.this.das.put(valueOf, obj);
                    } else {
                        d my = b.this.my(R.id.region_province);
                        if (my != null) {
                            b.this.das.put("l1", my);
                        }
                        d my2 = b.this.my(R.id.region_city);
                        if (my2 != null) {
                            b.this.das.put("l2", my2);
                        }
                        b.this.das.put("l3", b.this.my(R.id.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.daw.put(valueOf, true);
                    }
                    if (b.this.aDs() && b.this.aDt()) {
                        b.this.dau.gk(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.daw.put(valueOf, false);
                    b.this.dau.gk(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDs() {
        for (Boolean bool : this.daw.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDt() {
        for (Boolean bool : this.dav.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d my(int i) {
        Object tag;
        if (this.dar == null || (tag = this.dar.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private TextView daA;
        private EditText daB;
        private ImageView daC;
        private View daD;
        private View daq;

        public c(View view) {
            this.daq = view;
            this.daA = (TextView) view.findViewById(R.id.delivery_label);
            this.daB = (EditText) view.findViewById(R.id.delivery_content);
            this.daC = (ImageView) view.findViewById(R.id.delivery_arrow);
            this.daD = view.findViewById(R.id.delivery_highlight_line);
        }
    }
}
