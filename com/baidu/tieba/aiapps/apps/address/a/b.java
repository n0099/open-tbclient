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
public class b extends BaseAdapter implements a.InterfaceC0293a {
    private EditText ddN;
    private a ddP;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> ddO = new HashMap();
    private Map<String, Boolean> ddQ = new HashMap(5);
    private Map<String, Boolean> ddR = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void gr(boolean z);
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
    /* renamed from: mJ */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void p(Map<String, Boolean> map) {
        this.ddR = map;
    }

    public void q(Map<String, Boolean> map) {
        this.ddQ = map;
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
        this.ddP = aVar;
    }

    public boolean aFi() {
        return aFs();
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
        TextView textView = cVar.ddU;
        EditText editText = cVar.ddV;
        ImageView imageView = cVar.ddW;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.def) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0291b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.aFK();
                }
            });
            this.ddN = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!com.baidu.tieba.aiapps.apps.p.a.Fi()) {
            return;
        }
        cVar.ddM.setBackgroundColor(Color.parseColor("#191919"));
        cVar.ddU.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.ddV.setTextColor(Color.parseColor("#666666"));
        cVar.ddV.setHintTextColor(Color.parseColor("#333333"));
        cVar.ddX.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0293a
    public void aG(List<d> list) {
        if (list != null && list.size() == 3) {
            this.ddN.setTag(R.id.region_province, list.get(0));
            this.ddN.setTag(R.id.region_city, list.get(1));
            this.ddN.setTag(R.id.region_county, list.get(2));
            String aI = d.aI(list);
            if (this.ddN != null) {
                this.ddN.setText(aI);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.ddO;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0291b implements TextWatcher {
        private String ddT;
        private EditText mEditText;

        public C0291b(EditText editText) {
            this.mEditText = editText;
            this.ddT = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.ddT)) {
                    b.this.ddQ.put(valueOf, false);
                } else {
                    b.this.ddQ.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.ddN == null) {
                        b.this.ddO.put(valueOf, obj);
                    } else {
                        d mK = b.this.mK(R.id.region_province);
                        if (mK != null) {
                            b.this.ddO.put("l1", mK);
                        }
                        d mK2 = b.this.mK(R.id.region_city);
                        if (mK2 != null) {
                            b.this.ddO.put("l2", mK2);
                        }
                        b.this.ddO.put("l3", b.this.mK(R.id.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.ddR.put(valueOf, true);
                    }
                    if (b.this.aFr() && b.this.aFs()) {
                        b.this.ddP.gr(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.ddR.put(valueOf, false);
                    b.this.ddP.gr(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFr() {
        for (Boolean bool : this.ddR.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aFs() {
        for (Boolean bool : this.ddQ.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d mK(int i) {
        Object tag;
        if (this.ddN == null || (tag = this.ddN.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View ddM;
        private TextView ddU;
        private EditText ddV;
        private ImageView ddW;
        private View ddX;

        public c(View view) {
            this.ddM = view;
            this.ddU = (TextView) view.findViewById(R.id.delivery_label);
            this.ddV = (EditText) view.findViewById(R.id.delivery_content);
            this.ddW = (ImageView) view.findViewById(R.id.delivery_arrow);
            this.ddX = view.findViewById(R.id.delivery_highlight_line);
        }
    }
}
