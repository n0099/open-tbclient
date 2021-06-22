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
import d.a.n0.s.c.v;
import d.a.n0.w.n;
import d.a.o0.l0.b;
import d.a.o0.w3.i;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TopicDetaiInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static int r = 1;
    public static int s;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f16733e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f16734f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16735g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16736h;

    /* renamed from: i  reason: collision with root package name */
    public View f16737i;
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
            TopicDetaiInputContainer.this.d(new d.a.n0.w.a(8, -1, null));
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
            topicDetaiInputContainer.d(new d.a.n0.w.a(4, -1, topicDetaiInputContainer.f16734f.getText().toString()));
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
                TopicDetaiInputContainer.this.f16734f.setSelection(TopicDetaiInputContainer.this.n);
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
                TopicDetaiInputContainer.this.d(new d.a.n0.w.a(5, -1, null));
                TopicDetaiInputContainer.this.f16734f.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.f {
        public d() {
        }

        @Override // d.a.o0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            TopicDetaiInputContainer.this.f16734f.setText(spannableStringBuilder);
            TopicDetaiInputContainer.this.f16734f.setSelection(TopicDetaiInputContainer.this.f16734f.getText().length());
            TopicDetaiInputContainer.this.d(new d.a.n0.w.a(5, -1, null));
            TopicDetaiInputContainer.this.requestFocus();
        }
    }

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.a.n0.w.n
    public void b() {
        if (this.f16734f != null && this.f16736h.getVisibility() == 0) {
            this.f16734f.setFocusable(true);
            this.f16734f.setFocusableInTouchMode(true);
            this.f16734f.requestFocus();
            l.K(getContext(), this.f16734f);
        }
        setVisibility(0);
    }

    @Override // d.a.n0.w.n
    public void d(d.a.n0.w.a aVar) {
        EditorTools editorTools = this.f16733e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public LinearLayout getInputLayout() {
        return this.f16736h;
    }

    public EditText getInputView() {
        return this.f16734f;
    }

    public TextView getSendView() {
        return this.f16735g;
    }

    @Override // d.a.n0.w.n
    public int getToolId() {
        return this.j;
    }

    @Override // d.a.n0.w.n
    public void hide() {
        setVisibility(8);
    }

    public void i(int i2) {
        if (i2 == s) {
            boolean[] zArr = this.o;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.f16735g.setEnabled(false);
            } else {
                this.f16735g.setEnabled(true);
            }
        } else if (i2 == r) {
            if (this.o[1]) {
                this.f16735g.setEnabled(true);
            } else {
                this.f16735g.setEnabled(false);
            }
        }
    }

    @Override // d.a.n0.w.n
    public void init() {
    }

    public final void j(Context context) {
        EditText editText = new EditText(context);
        this.f16734f = editText;
        editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f16734f.setMaxLines(4);
        this.f16734f.setGravity(16);
        this.f16734f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.f16734f.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.f16734f.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.f16734f.setBackgroundResource(R.color.common_color_10022);
        i.e(this.f16734f, R.drawable.edittext_cursor);
        this.f16734f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
        this.f16734f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f16734f.addTextChangedListener(new b());
        this.f16734f.setOnTouchListener(new c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.g(context, R.dimen.ds14), 0, 0, 0);
        this.f16736h.addView(this.f16734f, layoutParams);
    }

    public final void k(Context context) {
        TextView textView = new TextView(context);
        this.f16735g = textView;
        textView.setGravity(17);
        this.f16735g.setIncludeFontPadding(false);
        this.f16735g.setEnabled(false);
        this.f16735g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.f16735g.setText(R.string.pb_send_post);
        this.f16735g.setOnClickListener(new a());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.g(context, R.dimen.tbds14), 0);
        this.f16736h.addView(this.f16735g, layoutParams);
    }

    public final void l(d.a.n0.w.a aVar) {
        Object obj;
        if (aVar == null || (obj = aVar.f54627c) == null || !(obj instanceof v)) {
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
            String obj = this.f16734f.getText().toString();
            if (this.l && d.a.o0.l0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.a.o0.l0.b.b(getContext(), vVar, this.f16734f);
            }
        }
    }

    public final void n(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f16734f.getText().toString();
        if (this.l && d.a.o0.l0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.o0.l0.b.c(getContext(), vVar, this.f16734f);
        }
    }

    @Override // d.a.n0.w.b
    public void onAction(d.a.n0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f54625a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 6) {
                    Object obj = aVar.f54627c;
                    if (obj == null) {
                        this.f16734f.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.f16734f.setText((CharSequence) null);
                        } else {
                            d.a.o0.l0.b.d(getContext(), (String) aVar.f54627c, new d());
                        }
                    }
                } else if (i2 == 9) {
                    if (((Boolean) aVar.f54627c).booleanValue()) {
                        this.f16734f.setText((CharSequence) null);
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
                    Object obj2 = aVar.f54627c;
                    if (!(obj2 instanceof d.a.n0.w.r.a)) {
                        return;
                    }
                    d.a.n0.w.r.a aVar2 = (d.a.n0.w.r.a) obj2;
                    WriteImagesInfo writeImagesInfo = aVar2.f54648a;
                    if (writeImagesInfo != null) {
                        if (writeImagesInfo.getChosedFiles() != null) {
                            this.p[0] = aVar2.f54648a.getChosedFiles().size();
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
            Object obj3 = aVar.f54627c;
            if (obj3 != null && (!(obj3 instanceof String) || !StringUtils.isNull((String) obj3))) {
                this.o[0] = true;
            } else {
                this.o[0] = false;
            }
        } else if (this.f16734f.getSelectionStart() > 0) {
            String substring = this.f16734f.getText().toString().substring(0, this.f16734f.getSelectionStart());
            Matcher matcher = d.a.o0.l0.a.f60968b.matcher(substring);
            if (matcher.find()) {
                this.f16734f.getText().delete(this.f16734f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f16734f.getSelectionStart());
            } else {
                this.f16734f.getText().delete(this.f16734f.getSelectionStart() - 1, this.f16734f.getSelectionStart());
            }
        }
        i(this.q);
    }

    @Override // d.a.n0.w.n
    public void onChangeSkinType(int i2) {
        SkinManager.setViewTextColor(this.f16734f, R.color.CAM_X0105, 2, i2);
        SkinManager.setBackgroundColor(this.f16737i, R.color.CAM_X0207);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
        if (i2 == 0) {
            i.e(this.f16734f, R.drawable.edittext_cursor);
            this.f16734f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            i.e(this.f16734f, R.drawable.edittext_cursor_1);
            this.f16734f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0110));
        }
        SkinManager.setBackgroundResource(this.f16735g, R.drawable.topic_discuss_send_bg);
        if (i2 != 1 && i2 != 4) {
            SkinManager.setViewTextColor(this.f16735g, R.color.CAM_X0101, 1);
        } else {
            this.f16735g.setTextColor(getResources().getColor(R.color.CAM_X0101));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.n0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f16733e = editorTools;
    }

    public void setHasHint(boolean z) {
    }

    public void setHint(int i2) {
        EditText editText = this.f16734f;
        if (editText != null) {
            editText.setHint(getContext().getString(i2));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.k = z;
    }

    @Override // d.a.n0.w.n
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
        this.f16736h = linearLayout;
        linearLayout.setOrientation(0);
        this.f16736h.setMinimumHeight(l.g(context, R.dimen.ds90));
        addView(this.f16736h, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        this.f16737i = new View(getContext());
        this.f16737i.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.f16737i);
    }

    public void setHint(CharSequence charSequence) {
        EditText editText = this.f16734f;
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }
}
