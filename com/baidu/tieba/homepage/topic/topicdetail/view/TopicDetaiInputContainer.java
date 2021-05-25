package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.s.c.v;
import d.a.m0.w.n;
import d.a.n0.l0.b;
import d.a.n0.w3.i;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TopicDetaiInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static int r = 1;
    public static int s;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f16575e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f16576f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16577g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16578h;

    /* renamed from: i  reason: collision with root package name */
    public View f16579i;
    public int j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean[] o;
    public int[] p;
    public int q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TopicDetaiInputContainer.this.d(new d.a.m0.w.a(8, -1, null));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.toString().trim() == null) {
                return;
            }
            TopicDetaiInputContainer topicDetaiInputContainer = TopicDetaiInputContainer.this;
            topicDetaiInputContainer.d(new d.a.m0.w.a(4, -1, topicDetaiInputContainer.f16576f.getText().toString()));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (TopicDetaiInputContainer.this.m) {
                return;
            }
            TopicDetaiInputContainer.this.m = true;
            if (TopicDetaiInputContainer.this.n != -1) {
                TopicDetaiInputContainer.this.f16576f.setSelection(TopicDetaiInputContainer.this.n);
                TopicDetaiInputContainer.this.n = -1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                TopicDetaiInputContainer.this.d(new d.a.m0.w.a(5, -1, null));
                TopicDetaiInputContainer.this.f16576f.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.f {
        public d() {
        }

        @Override // d.a.n0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            TopicDetaiInputContainer.this.f16576f.setText(spannableStringBuilder);
            TopicDetaiInputContainer.this.f16576f.setSelection(TopicDetaiInputContainer.this.f16576f.getText().length());
            TopicDetaiInputContainer.this.d(new d.a.m0.w.a(5, -1, null));
            TopicDetaiInputContainer.this.requestFocus();
        }
    }

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.a.m0.w.n
    public void b() {
        if (this.f16576f != null && this.f16578h.getVisibility() == 0) {
            this.f16576f.setFocusable(true);
            this.f16576f.setFocusableInTouchMode(true);
            this.f16576f.requestFocus();
            l.K(getContext(), this.f16576f);
        }
        setVisibility(0);
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.f16575e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public LinearLayout getInputLayout() {
        return this.f16578h;
    }

    public EditText getInputView() {
        return this.f16576f;
    }

    public TextView getSendView() {
        return this.f16577g;
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.j;
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    public void i(int i2) {
        if (i2 == s) {
            boolean[] zArr = this.o;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.f16577g.setEnabled(false);
            } else {
                this.f16577g.setEnabled(true);
            }
        } else if (i2 == r) {
            if (this.o[1]) {
                this.f16577g.setEnabled(true);
            } else {
                this.f16577g.setEnabled(false);
            }
        }
    }

    @Override // d.a.m0.w.n
    public void init() {
    }

    public final void j(Context context) {
        EditText editText = new EditText(context);
        this.f16576f = editText;
        editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f16576f.setMaxLines(4);
        this.f16576f.setGravity(16);
        this.f16576f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f16576f.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.f16576f.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.f16576f.setBackgroundResource(R.color.common_color_10022);
        i.e(this.f16576f, R.drawable.edittext_cursor);
        this.f16576f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
        this.f16576f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f16576f.addTextChangedListener(new b());
        this.f16576f.setOnTouchListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.g(context, R.dimen.ds14), 0, 0, 0);
        this.f16578h.addView(this.f16576f, layoutParams);
    }

    public final void k(Context context) {
        TextView textView = new TextView(context);
        this.f16577g = textView;
        textView.setGravity(17);
        this.f16577g.setIncludeFontPadding(false);
        this.f16577g.setEnabled(false);
        this.f16577g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.f16577g.setText(R.string.pb_send_post);
        this.f16577g.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.tbds14), 0);
        this.f16578h.addView(this.f16577g, layoutParams);
    }

    public final void l(d.a.m0.w.a aVar) {
        Object obj;
        if (aVar == null || (obj = aVar.f50843c) == null || !(obj instanceof v)) {
            return;
        }
        v vVar = (v) obj;
        if (vVar.f() == EmotionGroupType.NET_SUG) {
            n(vVar);
        } else {
            m(vVar);
        }
    }

    public final void m(v vVar) {
        if (!this.k || vVar.f() == EmotionGroupType.LOCAL) {
            String obj = this.f16576f.getText().toString();
            if (this.l && d.a.n0.l0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.a.n0.l0.b.b(getContext(), vVar, this.f16576f);
            }
        }
    }

    public final void n(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f16576f.getText().toString();
        if (this.l && d.a.n0.l0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.n0.l0.b.c(getContext(), vVar, this.f16576f);
        }
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f50841a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 6) {
                    Object obj = aVar.f50843c;
                    if (obj == null) {
                        this.f16576f.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.f16576f.setText((CharSequence) null);
                        } else {
                            d.a.n0.l0.b.d(getContext(), (String) aVar.f50843c, new d());
                        }
                    }
                } else if (i2 == 9) {
                    if (((Boolean) aVar.f50843c).booleanValue()) {
                        this.f16576f.setText((CharSequence) null);
                    }
                    boolean[] zArr = this.o;
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    zArr[3] = false;
                    zArr[4] = false;
                    int[] iArr = this.p;
                    iArr[0] = 0;
                    iArr[1] = 0;
                } else if (i2 == 24) {
                    l(aVar);
                } else if (i2 == 12) {
                    Object obj2 = aVar.f50843c;
                    if (!(obj2 instanceof d.a.m0.w.r.a)) {
                        return;
                    }
                    d.a.m0.w.r.a aVar2 = (d.a.m0.w.r.a) obj2;
                    WriteImagesInfo writeImagesInfo = aVar2.f50864a;
                    if (writeImagesInfo != null) {
                        if (writeImagesInfo.getChosedFiles() != null) {
                            this.p[0] = aVar2.f50864a.getChosedFiles().size();
                        } else {
                            this.p[0] = 0;
                        }
                    }
                    if (this.p[0] > 0) {
                        this.o[1] = true;
                    } else {
                        this.o[1] = false;
                    }
                } else if (i2 == 13) {
                    int[] iArr2 = this.p;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] > 0) {
                        this.o[1] = true;
                    } else {
                        this.o[1] = false;
                    }
                }
            }
            Object obj3 = aVar.f50843c;
            if (obj3 != null && (!(obj3 instanceof String) || !StringUtils.isNull((String) obj3))) {
                this.o[0] = true;
            } else {
                this.o[0] = false;
            }
        } else if (this.f16576f.getSelectionStart() > 0) {
            String substring = this.f16576f.getText().toString().substring(0, this.f16576f.getSelectionStart());
            Matcher matcher = d.a.n0.l0.a.f57154b.matcher(substring);
            if (matcher.find()) {
                this.f16576f.getText().delete(this.f16576f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f16576f.getSelectionStart());
            } else {
                this.f16576f.getText().delete(this.f16576f.getSelectionStart() - 1, this.f16576f.getSelectionStart());
            }
        }
        i(this.q);
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f16576f, R.color.CAM_X0105, 2, i2);
        SkinManager.setBackgroundColor(this.f16579i, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        if (i2 == 0) {
            i.e(this.f16576f, R.drawable.edittext_cursor);
            this.f16576f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            i.e(this.f16576f, R.drawable.edittext_cursor_1);
            this.f16576f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0110));
        }
        SkinManager.setBackgroundResource(this.f16577g, R.drawable.topic_discuss_send_bg);
        if (i2 != 1 && i2 != 4) {
            SkinManager.setViewTextColor(this.f16577g, R.color.CAM_X0101, 1);
        } else {
            this.f16577g.setTextColor(getResources().getColor(R.color.CAM_X0101));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f16575e = editorTools;
    }

    public void setHasHint(boolean z) {
    }

    public void setHint(int i2) {
        EditText editText = this.f16576f;
        if (editText != null) {
            editText.setHint(getContext().getString(i2));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.k = z;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.j = i2;
    }

    public void setType(int i2) {
        this.q = i2;
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = -1;
        this.o = new boolean[]{false, false, false, false, false};
        this.p = new int[]{0, 0};
        this.q = s;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f16578h = linearLayout;
        linearLayout.setOrientation(0);
        this.f16578h.setMinimumHeight(l.g(context, R.dimen.ds90));
        addView(this.f16578h, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        this.f16579i = new View(getContext());
        this.f16579i.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.f16579i);
    }

    public void setHint(CharSequence charSequence) {
        EditText editText = this.f16576f;
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }
}
