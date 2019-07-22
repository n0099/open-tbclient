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
public class b extends BaseAdapter implements a.InterfaceC0278a {
    private EditText dbS;
    private a dbU;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> dbT = new HashMap();
    private Map<String, Boolean> dbV = new HashMap(5);
    private Map<String, Boolean> dbW = new HashMap(4);

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
    /* renamed from: mE */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.dbW = map;
    }

    public void q(Map<String, Boolean> map) {
        this.dbV = map;
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
        this.dbU = aVar;
    }

    public boolean aEC() {
        return aEM();
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
        TextView textView = cVar.dbZ;
        EditText editText = cVar.dca;
        ImageView imageView = cVar.dcb;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.dcl) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0276b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aFe();
                }
            });
            this.dbS = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.p.a.Fe()) {
            return;
        }
        cVar.dbR.setBackgroundColor(Color.parseColor("#191919"));
        cVar.dbZ.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.dca.setTextColor(Color.parseColor("#666666"));
        cVar.dca.setHintTextColor(Color.parseColor("#333333"));
        cVar.dcc.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0278a
    public void aG(List<d> list) {
        if (list != null && list.size() == 3) {
            this.dbS.setTag(R.id.region_province, list.get(0));
            this.dbS.setTag(R.id.region_city, list.get(1));
            this.dbS.setTag(R.id.region_county, list.get(2));
            String aI = d.aI(list);
            if (this.dbS != null) {
                this.dbS.setText(aI);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.dbT;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0276b implements TextWatcher {
        private String dbY;
        private EditText mEditText;

        public C0276b(EditText editText) {
            this.mEditText = editText;
            this.dbY = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.dbY)) {
                    b.this.dbV.put(valueOf, false);
                } else {
                    b.this.dbV.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.dbS == null) {
                        b.this.dbT.put(valueOf, obj);
                    } else {
                        d mF = b.this.mF(R.id.region_province);
                        if (mF != null) {
                            b.this.dbT.put("l1", mF);
                        }
                        d mF2 = b.this.mF(R.id.region_city);
                        if (mF2 != null) {
                            b.this.dbT.put("l2", mF2);
                        }
                        b.this.dbT.put("l3", b.this.mF(R.id.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.dbW.put(valueOf, true);
                    }
                    if (b.this.aEL() && b.this.aEM()) {
                        b.this.dbU.go(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.dbW.put(valueOf, false);
                    b.this.dbU.go(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEL() {
        for (Boolean bool : this.dbW.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEM() {
        for (Boolean bool : this.dbV.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d mF(int i) {
        Object tag;
        if (this.dbS == null || (tag = this.dbS.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View dbR;
        private TextView dbZ;
        private EditText dca;
        private ImageView dcb;
        private View dcc;

        public c(View view) {
            this.dbR = view;
            this.dbZ = (TextView) view.findViewById(R.id.delivery_label);
            this.dca = (EditText) view.findViewById(R.id.delivery_content);
            this.dcb = (ImageView) view.findViewById(R.id.delivery_arrow);
            this.dcc = view.findViewById(R.id.delivery_highlight_line);
        }
    }
}
