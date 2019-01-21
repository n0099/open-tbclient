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
    private EditText bGC;
    private a bGE;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> bGD = new HashMap();
    private Map<String, Boolean> bGF = new HashMap(5);
    private Map<String, Boolean> bGG = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void dw(boolean z);
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
        this.bGG = map;
    }

    public void p(Map<String, Boolean> map) {
        this.bGF = map;
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
        this.bGE = aVar;
    }

    public boolean Yb() {
        return Yk();
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
        TextView textView = cVar.bGJ;
        EditText editText = cVar.bGK;
        ImageView imageView = cVar.bGL;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.bGU) {
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
                    aVar.YC();
                }
            });
            this.bGC = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!AiAppNightModeHelper.getNightModeSwitcherState()) {
            return;
        }
        cVar.bGB.setBackgroundColor(Color.parseColor("#191919"));
        cVar.bGJ.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.bGK.setTextColor(Color.parseColor("#666666"));
        cVar.bGK.setHintTextColor(Color.parseColor("#333333"));
        cVar.bGM.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0196a
    public void am(List<d> list) {
        if (list != null && list.size() == 3) {
            this.bGC.setTag(e.g.region_province, list.get(0));
            this.bGC.setTag(e.g.region_city, list.get(1));
            this.bGC.setTag(e.g.region_county, list.get(2));
            String ao = d.ao(list);
            if (this.bGC != null) {
                this.bGC.setText(ao);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bGD;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0194b implements TextWatcher {
        private String bGI;
        private EditText mEditText;

        public C0194b(EditText editText) {
            this.mEditText = editText;
            this.bGI = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.bGI)) {
                    b.this.bGF.put(valueOf, false);
                } else {
                    b.this.bGF.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.bGC == null) {
                        b.this.bGD.put(valueOf, obj);
                    } else {
                        d hV = b.this.hV(e.g.region_province);
                        if (hV != null) {
                            b.this.bGD.put("l1", hV);
                        }
                        d hV2 = b.this.hV(e.g.region_city);
                        if (hV2 != null) {
                            b.this.bGD.put("l2", hV2);
                        }
                        b.this.bGD.put("l3", b.this.hV(e.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.bGG.put(valueOf, true);
                    }
                    if (b.this.Yj() && b.this.Yk()) {
                        b.this.bGE.dw(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.bGG.put(valueOf, false);
                    b.this.bGE.dw(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yj() {
        for (Boolean bool : this.bGG.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yk() {
        for (Boolean bool : this.bGF.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d hV(int i) {
        Object tag;
        if (this.bGC == null || (tag = this.bGC.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View bGB;
        private TextView bGJ;
        private EditText bGK;
        private ImageView bGL;
        private View bGM;

        public c(View view) {
            this.bGB = view;
            this.bGJ = (TextView) view.findViewById(e.g.delivery_label);
            this.bGK = (EditText) view.findViewById(e.g.delivery_content);
            this.bGL = (ImageView) view.findViewById(e.g.delivery_arrow);
            this.bGM = view.findViewById(e.g.delivery_highlight_line);
        }
    }
}
