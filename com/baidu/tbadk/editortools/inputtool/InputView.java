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
import d.b.i0.s.c.v;
import d.b.i0.w.n;
import d.b.j0.k0.b;
import d.b.j0.v3.j;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class InputView extends EditText implements n {

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13539e;

    /* renamed from: f  reason: collision with root package name */
    public int f13540f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13541g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13542h;
    public boolean i;
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
            inputView.d(new d.b.i0.w.a(4, -1, inputView.getText().toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (InputView.this.i) {
                return;
            }
            InputView.this.i = true;
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
                InputView.this.d(new d.b.i0.w.a(5, -1, null));
                InputView.this.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.f {
        public c() {
        }

        @Override // d.b.j0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            InputView.this.setText(spannableStringBuilder);
            InputView inputView = InputView.this;
            inputView.setSelection(inputView.getText().length());
            InputView.this.d(new d.b.i0.w.a(5, -1, null));
            InputView.this.requestFocus();
        }
    }

    public InputView(Context context, boolean z) {
        super(context);
        this.f13540f = 0;
        this.f13541g = false;
        this.f13542h = true;
        this.i = true;
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
        j.e(this, R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new a());
        setOnTouchListener(new b());
    }

    @Override // d.b.i0.w.n
    public void b() {
        setVisibility(0);
    }

    @Override // d.b.i0.w.n
    public void d(d.b.i0.w.a aVar) {
        EditorTools editorTools = this.f13539e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    @Override // d.b.i0.w.n
    public int getToolId() {
        return this.f13540f;
    }

    public final void h(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append("@");
            sb.append(arrayList.get(i));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        getText().insert(getSelectionStart(), sb2);
    }

    @Override // d.b.i0.w.n
    public void hide() {
        setVisibility(8);
    }

    public final void i(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // d.b.i0.w.n
    public void init() {
    }

    public final void j(d.b.i0.w.a aVar) {
        Object obj;
        if (aVar == null || (obj = aVar.f52280c) == null || !(obj instanceof v)) {
            return;
        }
        v vVar = (v) obj;
        if (vVar.e() == EmotionGroupType.NET_SUG) {
            l(vVar);
        } else {
            k(vVar);
        }
    }

    public final void k(v vVar) {
        if (!this.f13541g || vVar.e() == EmotionGroupType.LOCAL) {
            String obj = getText().toString();
            if (this.f13542h && d.b.j0.k0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.b.j0.k0.b.b(getContext(), vVar, this);
            }
        }
    }

    public final void l(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.b()) || TextUtils.isEmpty(vVar.f())) {
            return;
        }
        String obj = getText().toString();
        if (this.f13542h && d.b.j0.k0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.b.j0.k0.b.c(getContext(), vVar, this);
        }
    }

    @Override // d.b.i0.w.b
    public void onAction(d.b.i0.w.a aVar) {
        Object obj;
        if (aVar == null) {
            return;
        }
        int i = aVar.f52278a;
        if (i == 3) {
            if (getSelectionStart() > 0) {
                String substring = getText().toString().substring(0, getSelectionStart());
                Matcher matcher = d.b.j0.k0.a.f58263b.matcher(substring);
                if (matcher.find()) {
                    getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                } else {
                    getText().delete(getSelectionStart() - 1, getSelectionStart());
                }
            }
        } else if (i == 6) {
            Object obj2 = aVar.f52280c;
            if (obj2 == null) {
                setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    setText((CharSequence) null);
                } else {
                    d.b.j0.k0.b.d(getContext(), (String) aVar.f52280c, new c());
                }
            }
        } else if (i == 9) {
            if (((Boolean) aVar.f52280c).booleanValue()) {
                setText((CharSequence) null);
            }
        } else if (i == 17) {
            Object obj3 = aVar.f52280c;
            if (obj3 == null || !(obj3 instanceof ArrayList)) {
                return;
            }
            h((ArrayList) obj3);
        } else if (i == 24) {
            j(aVar);
        } else if (i == 44 && (obj = aVar.f52280c) != null && (obj instanceof String)) {
            i((String) obj);
        }
    }

    @Override // d.b.i0.w.n
    public void onChangeSkinType(int i) {
        SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i);
        if (i == 0) {
            j.e(this, R.drawable.edittext_cursor);
            setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
            return;
        }
        j.e(this, R.drawable.edittext_cursor_1);
        setHintTextColor(SkinManager.getColor(i, R.color.CAM_X0110));
    }

    @Override // d.b.i0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f13539e = editorTools;
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.f13541g = z;
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.f13542h = z;
    }

    @Override // d.b.i0.w.n
    public void setToolId(int i) {
        this.f13540f = i;
    }
}
