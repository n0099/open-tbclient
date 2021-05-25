package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import d.a.m0.s.c.v;
import d.a.m0.w.n;
import d.a.n0.l0.b;
import d.a.n0.w3.i;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class InputView extends EditText implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f12774e;

    /* renamed from: f  reason: collision with root package name */
    public int f12775f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12776g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12777h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12778i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.toString().trim() == null) {
                return;
            }
            InputView inputView = InputView.this;
            inputView.d(new d.a.m0.w.a(4, -1, inputView.getText().toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (InputView.this.f12778i) {
                return;
            }
            InputView.this.f12778i = true;
            if (InputView.this.j != -1) {
                InputView inputView = InputView.this;
                inputView.setSelection(inputView.j);
                InputView.this.j = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                InputView.this.d(new d.a.m0.w.a(5, -1, null));
                InputView.this.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.f {
        public c() {
        }

        @Override // d.a.n0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            InputView.this.setText(spannableStringBuilder);
            InputView inputView = InputView.this;
            inputView.setSelection(inputView.getText().length());
            InputView.this.d(new d.a.m0.w.a(5, -1, null));
            InputView.this.requestFocus();
        }
    }

    public InputView(Context context, boolean z) {
        super(context);
        this.f12775f = 0;
        this.f12776g = false;
        this.f12777h = true;
        this.f12778i = true;
        this.j = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds64));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(R.string.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        setTextColor(getResources().getColor(R.color.CAM_X0106));
        setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        setBackgroundResource(R.color.common_color_10022);
        i.e(this, R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new a());
        setOnTouchListener(new b());
    }

    @Override // d.a.m0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.f12774e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.f12775f;
    }

    public final void h(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append("@");
            sb.append(arrayList.get(i2));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        getText().insert(getSelectionStart(), sb2);
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // d.a.m0.w.n
    public void init() {
    }

    public final void j(d.a.m0.w.a aVar) {
        Object obj;
        if (aVar == null || (obj = aVar.f50843c) == null || !(obj instanceof v)) {
            return;
        }
        v vVar = (v) obj;
        if (vVar.f() == EmotionGroupType.NET_SUG) {
            l(vVar);
        } else {
            k(vVar);
        }
    }

    public final void k(v vVar) {
        if (!this.f12776g || vVar.f() == EmotionGroupType.LOCAL) {
            String obj = getText().toString();
            if (this.f12777h && d.a.n0.l0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.a.n0.l0.b.b(getContext(), vVar, this);
            }
        }
    }

    public final void l(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = getText().toString();
        if (this.f12777h && d.a.n0.l0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.n0.l0.b.c(getContext(), vVar, this);
        }
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f50841a;
        if (i2 == 3) {
            if (getSelectionStart() > 0) {
                String substring = getText().toString().substring(0, getSelectionStart());
                Matcher matcher = d.a.n0.l0.a.f57154b.matcher(substring);
                if (matcher.find()) {
                    getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                } else {
                    getText().delete(getSelectionStart() - 1, getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f50843c;
            if (obj2 == null) {
                setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    setText((CharSequence) null);
                } else {
                    d.a.n0.l0.b.d(getContext(), (String) aVar.f50843c, new c());
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f50843c).booleanValue()) {
                setText((CharSequence) null);
            }
        } else if (i2 == 17) {
            Object obj3 = aVar.f50843c;
            if (obj3 == null || !(obj3 instanceof ArrayList)) {
                return;
            }
            h((ArrayList) obj3);
        } else if (i2 == 24) {
            j(aVar);
        } else if (i2 == 44 && (obj = aVar.f50843c) != null && (obj instanceof String)) {
            i((String) obj);
        }
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i2);
        if (i2 == 0) {
            i.e(this, R.drawable.edittext_cursor);
            setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
            return;
        }
        i.e(this, R.drawable.edittext_cursor_1);
        setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0110));
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f12774e = editorTools;
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.f12776g = z;
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.f12777h = z;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.f12775f = i2;
    }
}
