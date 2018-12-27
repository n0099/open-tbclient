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
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeHelper;
import com.baidu.tieba.aiapps.apps.address.c.d;
import com.baidu.tieba.aiapps.apps.address.view.a;
import com.baidu.tieba.e;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends BaseAdapter implements a.InterfaceC0196a {
    private EditText bFO;
    private a bFQ;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> bFP = new HashMap();
    private Map<String, Boolean> bFR = new HashMap(5);
    private Map<String, Boolean> bFS = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void dt(boolean z);
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
    /* renamed from: hU */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void o(Map<String, Boolean> map) {
        this.bFS = map;
    }

    public void p(Map<String, Boolean> map) {
        this.bFR = map;
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
        this.bFQ = aVar;
    }

    public boolean XE() {
        return XN();
    }

    @Override // android.widget.Adapter
    @NonNull
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        c cVar;
        com.baidu.tieba.aiapps.apps.address.c.a item = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(e.h.delivery_edit_item_layout, viewGroup, false);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        a(cVar);
        TextView textView = cVar.bFV;
        EditText editText = cVar.bFW;
        ImageView imageView = cVar.bFX;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.bGg) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0194b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.Yf();
                }
            });
            this.bFO = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!AiAppNightModeHelper.getNightModeSwitcherState()) {
            return;
        }
        cVar.bFN.setBackgroundColor(Color.parseColor("#191919"));
        cVar.bFV.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.bFW.setTextColor(Color.parseColor("#666666"));
        cVar.bFW.setHintTextColor(Color.parseColor("#333333"));
        cVar.bFY.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0196a
    public void al(List<d> list) {
        if (list != null && list.size() == 3) {
            this.bFO.setTag(e.g.region_province, list.get(0));
            this.bFO.setTag(e.g.region_city, list.get(1));
            this.bFO.setTag(e.g.region_county, list.get(2));
            String an = d.an(list);
            if (this.bFO != null) {
                this.bFO.setText(an);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bFP;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0194b implements TextWatcher {
        private String bFU;
        private EditText mEditText;

        public C0194b(EditText editText) {
            this.mEditText = editText;
            this.bFU = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.bFU)) {
                    b.this.bFR.put(valueOf, false);
                } else {
                    b.this.bFR.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.bFO == null) {
                        b.this.bFP.put(valueOf, obj);
                    } else {
                        d hV = b.this.hV(e.g.region_province);
                        if (hV != null) {
                            b.this.bFP.put("l1", hV);
                        }
                        d hV2 = b.this.hV(e.g.region_city);
                        if (hV2 != null) {
                            b.this.bFP.put("l2", hV2);
                        }
                        b.this.bFP.put("l3", b.this.hV(e.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.bFS.put(valueOf, true);
                    }
                    if (b.this.XM() && b.this.XN()) {
                        b.this.bFQ.dt(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.bFS.put(valueOf, false);
                    b.this.bFQ.dt(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XM() {
        for (Boolean bool : this.bFS.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean XN() {
        for (Boolean bool : this.bFR.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hV(int i) {
        Object tag;
        if (this.bFO == null || (tag = this.bFO.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View bFN;
        private TextView bFV;
        private EditText bFW;
        private ImageView bFX;
        private View bFY;

        public c(View view) {
            this.bFN = view;
            this.bFV = (TextView) view.findViewById(e.g.delivery_label);
            this.bFW = (EditText) view.findViewById(e.g.delivery_content);
            this.bFX = (ImageView) view.findViewById(e.g.delivery_arrow);
            this.bFY = view.findViewById(e.g.delivery_highlight_line);
        }
    }
}
