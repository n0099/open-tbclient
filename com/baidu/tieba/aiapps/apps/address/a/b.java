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
public class b extends BaseAdapter implements a.InterfaceC0186a {
    private EditText bCs;
    private a bCu;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> bCt = new HashMap();
    private Map<String, Boolean> bCv = new HashMap(5);
    private Map<String, Boolean> bCw = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void ds(boolean z);
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
    /* renamed from: hF */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void l(Map<String, Boolean> map) {
        this.bCw = map;
    }

    public void m(Map<String, Boolean> map) {
        this.bCv = map;
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
        this.bCu = aVar;
    }

    public boolean Wz() {
        return WI();
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
        TextView textView = cVar.bCz;
        EditText editText = cVar.bCA;
        ImageView imageView = cVar.bCB;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.bCK) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0184b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.Xa();
                }
            });
            this.bCs = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!AiAppNightModeHelper.getNightModeSwitcherState()) {
            return;
        }
        cVar.bCr.setBackgroundColor(Color.parseColor("#191919"));
        cVar.bCz.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.bCA.setTextColor(Color.parseColor("#666666"));
        cVar.bCA.setHintTextColor(Color.parseColor("#333333"));
        cVar.bCC.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0186a
    public void al(List<d> list) {
        if (list != null && list.size() == 3) {
            this.bCs.setTag(e.g.region_province, list.get(0));
            this.bCs.setTag(e.g.region_city, list.get(1));
            this.bCs.setTag(e.g.region_county, list.get(2));
            String an = d.an(list);
            if (this.bCs != null) {
                this.bCs.setText(an);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bCt;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0184b implements TextWatcher {
        private String bCy;
        private EditText mEditText;

        public C0184b(EditText editText) {
            this.mEditText = editText;
            this.bCy = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.bCy)) {
                    b.this.bCv.put(valueOf, false);
                } else {
                    b.this.bCv.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.bCs == null) {
                        b.this.bCt.put(valueOf, obj);
                    } else {
                        d hG = b.this.hG(e.g.region_province);
                        if (hG != null) {
                            b.this.bCt.put("l1", hG);
                        }
                        d hG2 = b.this.hG(e.g.region_city);
                        if (hG2 != null) {
                            b.this.bCt.put("l2", hG2);
                        }
                        b.this.bCt.put("l3", b.this.hG(e.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.bCw.put(valueOf, true);
                    }
                    if (b.this.WH() && b.this.WI()) {
                        b.this.bCu.ds(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.bCw.put(valueOf, false);
                    b.this.bCu.ds(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WH() {
        for (Boolean bool : this.bCw.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WI() {
        for (Boolean bool : this.bCv.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hG(int i) {
        Object tag;
        if (this.bCs == null || (tag = this.bCs.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private EditText bCA;
        private ImageView bCB;
        private View bCC;
        private View bCr;
        private TextView bCz;

        public c(View view) {
            this.bCr = view;
            this.bCz = (TextView) view.findViewById(e.g.delivery_label);
            this.bCA = (EditText) view.findViewById(e.g.delivery_content);
            this.bCB = (ImageView) view.findViewById(e.g.delivery_arrow);
            this.bCC = view.findViewById(e.g.delivery_highlight_line);
        }
    }
}
