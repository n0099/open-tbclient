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
public class b extends BaseAdapter implements a.InterfaceC0284a {
    private EditText dbZ;
    private a dcb;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> dca = new HashMap();
    private Map<String, Boolean> dcc = new HashMap(5);
    private Map<String, Boolean> dcd = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void go(boolean z);
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
    /* renamed from: mF */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.dcd = map;
    }

    public void q(Map<String, Boolean> map) {
        this.dcc = map;
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
        this.dcb = aVar;
    }

    public boolean aEE() {
        return aEO();
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
        TextView textView = cVar.dch;
        EditText editText = cVar.dci;
        ImageView imageView = cVar.dcj;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.dcs) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0282b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aFg();
                }
            });
            this.dbZ = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.p.a.Fe()) {
            return;
        }
        cVar.dbY.setBackgroundColor(Color.parseColor("#191919"));
        cVar.dch.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.dci.setTextColor(Color.parseColor("#666666"));
        cVar.dci.setHintTextColor(Color.parseColor("#333333"));
        cVar.dck.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0284a
    public void aG(List<d> list) {
        if (list != null && list.size() == 3) {
            this.dbZ.setTag(R.id.region_province, list.get(0));
            this.dbZ.setTag(R.id.region_city, list.get(1));
            this.dbZ.setTag(R.id.region_county, list.get(2));
            String aI = d.aI(list);
            if (this.dbZ != null) {
                this.dbZ.setText(aI);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dca;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0282b implements TextWatcher {
        private String dcg;
        private EditText mEditText;

        public C0282b(EditText editText) {
            this.mEditText = editText;
            this.dcg = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.dcg)) {
                    b.this.dcc.put(valueOf, false);
                } else {
                    b.this.dcc.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.dbZ == null) {
                        b.this.dca.put(valueOf, obj);
                    } else {
                        d mG = b.this.mG(R.id.region_province);
                        if (mG != null) {
                            b.this.dca.put("l1", mG);
                        }
                        d mG2 = b.this.mG(R.id.region_city);
                        if (mG2 != null) {
                            b.this.dca.put("l2", mG2);
                        }
                        b.this.dca.put("l3", b.this.mG(R.id.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.dcd.put(valueOf, true);
                    }
                    if (b.this.aEN() && b.this.aEO()) {
                        b.this.dcb.go(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.dcd.put(valueOf, false);
                    b.this.dcb.go(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEN() {
        for (Boolean bool : this.dcd.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEO() {
        for (Boolean bool : this.dcc.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d mG(int i) {
        Object tag;
        if (this.dbZ == null || (tag = this.dbZ.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View dbY;
        private TextView dch;
        private EditText dci;
        private ImageView dcj;
        private View dck;

        public c(View view) {
            this.dbY = view;
            this.dch = (TextView) view.findViewById(R.id.delivery_label);
            this.dci = (EditText) view.findViewById(R.id.delivery_content);
            this.dcj = (ImageView) view.findViewById(R.id.delivery_arrow);
            this.dck = view.findViewById(R.id.delivery_highlight_line);
        }
    }
}
