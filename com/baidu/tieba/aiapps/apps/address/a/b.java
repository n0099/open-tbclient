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
public class b extends BaseAdapter implements a.InterfaceC0161a {
    private EditText bBG;
    private a bBI;
    private Context mContext;
    private List<com.baidu.tieba.aiapps.apps.address.c.a> mDataList;
    private Map<String, Object> bBH = new HashMap();
    private Map<String, Boolean> bBJ = new HashMap(5);
    private Map<String, Boolean> bBK = new HashMap(4);

    /* loaded from: classes4.dex */
    public interface a {
        void db(boolean z);
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
    /* renamed from: hs */
    public com.baidu.tieba.aiapps.apps.address.c.a getItem(int i) {
        return this.mDataList.get(i);
    }

    public void l(Map<String, Boolean> map) {
        this.bBK = map;
    }

    public void m(Map<String, Boolean> map) {
        this.bBJ = map;
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
        this.bBI = aVar;
    }

    public boolean Wp() {
        return Wy();
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
        TextView textView = cVar.bBN;
        EditText editText = cVar.bBO;
        ImageView imageView = cVar.bBP;
        textView.setText(item.label);
        editText.setText(item.content);
        editText.setHint(item.hint);
        editText.setTag(item.type);
        if (item.bBY) {
            editText.setInputType(2);
        }
        editText.addTextChangedListener(new C0159b(editText));
        if (TextUtils.equals(item.type, "region")) {
            editText.setFocusable(false);
            imageView.setVisibility(0);
            editText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.aiapps.apps.address.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.baidu.tieba.aiapps.apps.address.view.a aVar = new com.baidu.tieba.aiapps.apps.address.view.a(b.this.mContext);
                    aVar.a(b.this);
                    aVar.WQ();
                }
            });
            this.bBG = editText;
        }
        return view;
    }

    public void a(c cVar) {
        if (!AiAppNightModeHelper.getNightModeSwitcherState()) {
            return;
        }
        cVar.bBF.setBackgroundColor(Color.parseColor("#191919"));
        cVar.bBN.setTextColor(Color.parseColor("#4D4D4D"));
        cVar.bBO.setTextColor(Color.parseColor("#666666"));
        cVar.bBO.setHintTextColor(Color.parseColor("#333333"));
        cVar.bBQ.setBackgroundColor(Color.parseColor("#222222"));
    }

    @Override // com.baidu.tieba.aiapps.apps.address.view.a.InterfaceC0161a
    public void am(List<d> list) {
        if (list != null && list.size() == 3) {
            this.bBG.setTag(e.g.region_province, list.get(0));
            this.bBG.setTag(e.g.region_city, list.get(1));
            this.bBG.setTag(e.g.region_county, list.get(2));
            String ao = d.ao(list);
            if (this.bBG != null) {
                this.bBG.setText(ao);
            }
        }
    }

    public Map<String, Object> getDeliveryEditData() {
        return this.bBH;
    }

    /* renamed from: com.baidu.tieba.aiapps.apps.address.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0159b implements TextWatcher {
        private String bBM;
        private EditText mEditText;

        public C0159b(EditText editText) {
            this.mEditText = editText;
            this.bBM = this.mEditText.getText().toString();
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
                if (TextUtils.equals(editable.toString(), this.bBM)) {
                    b.this.bBJ.put(valueOf, false);
                } else {
                    b.this.bBJ.put(valueOf, true);
                }
                if (editable != null && !TextUtils.isEmpty(editable.toString())) {
                    String obj = editable.toString();
                    if (!TextUtils.equals(valueOf, "region") || b.this.bBG == null) {
                        b.this.bBH.put(valueOf, obj);
                    } else {
                        d ht = b.this.ht(e.g.region_province);
                        if (ht != null) {
                            b.this.bBH.put("l1", ht);
                        }
                        d ht2 = b.this.ht(e.g.region_city);
                        if (ht2 != null) {
                            b.this.bBH.put("l2", ht2);
                        }
                        b.this.bBH.put("l3", b.this.ht(e.g.region_county));
                    }
                    if (!TextUtils.equals(valueOf, "zipcode")) {
                        b.this.bBK.put(valueOf, true);
                    }
                    if (b.this.Wx() && b.this.Wy()) {
                        b.this.bBI.db(false);
                    }
                } else if (!TextUtils.equals(valueOf, "zipcode")) {
                    b.this.bBK.put(valueOf, false);
                    b.this.bBI.db(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wx() {
        for (Boolean bool : this.bBK.values()) {
            if (!bool.booleanValue()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Wy() {
        for (Boolean bool : this.bBJ.values()) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d ht(int i) {
        Object tag;
        if (this.bBG == null || (tag = this.bBG.getTag(i)) == null || !(tag instanceof d)) {
            return null;
        }
        return (d) tag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c {
        private View bBF;
        private TextView bBN;
        private EditText bBO;
        private ImageView bBP;
        private View bBQ;

        public c(View view) {
            this.bBF = view;
            this.bBN = (TextView) view.findViewById(e.g.delivery_label);
            this.bBO = (EditText) view.findViewById(e.g.delivery_content);
            this.bBP = (ImageView) view.findViewById(e.g.delivery_arrow);
            this.bBQ = view.findViewById(e.g.delivery_highlight_line);
        }
    }
}
