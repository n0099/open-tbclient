package com.baidu.tbadk.editortools.pb;

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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
import d.b.h0.s.c.t;
import d.b.h0.w.n;
import d.b.h0.w.w.j;
import d.b.i0.k0.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class PbNewInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static int x = 1;
    public static int y;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13885e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupEditText f13886f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f13887g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f13888h;
    public LinearLayout i;
    public View j;
    public TextView k;
    public int l;
    public j m;
    public SpannableStringBuilder n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean[] t;
    public int[] u;
    public int v;
    public Runnable w;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PbNewInputContainer.this.f13886f != null) {
                PbNewInputContainer pbNewInputContainer = PbNewInputContainer.this;
                pbNewInputContainer.d(new d.b.h0.w.a(4, -1, pbNewInputContainer.f13886f.getSpanGroupManager()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbNewInputContainer.this.d(new d.b.h0.w.a(8, -1, null));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null || editable.toString().trim() == null) {
                return;
            }
            if (!TextUtils.isEmpty(PbNewInputContainer.this.n)) {
                if (PbNewInputContainer.this.m == null) {
                    PbNewInputContainer.this.m = new j();
                }
                PbNewInputContainer.this.m.f51607b = PbNewInputContainer.this.n.toString();
                PbNewInputContainer.this.m.f51606a = PbNewInputContainer.this.f13886f.getText().toString();
                PbNewInputContainer.this.m.f51608c = PbNewInputContainer.this.f13886f.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = PbNewInputContainer.this;
                pbNewInputContainer.d(new d.b.h0.w.a(4, -1, pbNewInputContainer.m));
                return;
            }
            d.b.b.e.m.e.a().removeCallbacks(PbNewInputContainer.this.w);
            d.b.b.e.m.e.a().post(PbNewInputContainer.this.w);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (PbNewInputContainer.this.r) {
                return;
            }
            PbNewInputContainer.this.r = true;
            if (PbNewInputContainer.this.s != -1) {
                PbNewInputContainer.this.f13886f.setSelection(PbNewInputContainer.this.s);
                PbNewInputContainer.this.s = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                PbNewInputContainer.this.d(new d.b.h0.w.a(5, -1, null));
                PbNewInputContainer.this.f13886f.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.f {
        public e() {
        }

        @Override // d.b.i0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbNewInputContainer.this.f13886f.setText(spannableStringBuilder);
            PbNewInputContainer.this.f13886f.setSelection(PbNewInputContainer.this.f13886f.getText().length());
            PbNewInputContainer.this.d(new d.b.h0.w.a(5, -1, null));
            PbNewInputContainer.this.requestFocus();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f13894a;

        public f(j jVar) {
            this.f13894a = jVar;
        }

        @Override // d.b.i0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbNewInputContainer.this.n = spannableStringBuilder;
            if (TextUtils.isEmpty(this.f13894a.f51606a)) {
                PbNewInputContainer.this.f13886f.setText("");
                PbNewInputContainer.this.d(new d.b.h0.w.a(5, -1, null));
                PbNewInputContainer.this.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements b.f {
        public g() {
        }

        @Override // d.b.i0.k0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbNewInputContainer.this.f13886f.setText(spannableStringBuilder);
            PbNewInputContainer.this.f13886f.setSelection(PbNewInputContainer.this.f13886f.getText().length());
            PbNewInputContainer.this.d(new d.b.h0.w.a(5, -1, null));
            PbNewInputContainer.this.requestFocus();
        }
    }

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.b.h0.w.n
    public void b() {
        if (this.f13886f != null && this.i.getVisibility() == 0) {
            this.f13886f.setFocusable(true);
            this.f13886f.setFocusableInTouchMode(true);
            this.f13886f.requestFocus();
            l.J(getContext(), this.f13886f);
        }
        setVisibility(0);
    }

    @Override // d.b.h0.w.n
    public void d(d.b.h0.w.a aVar) {
        EditorTools editorTools = this.f13885e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public LinearLayout getInputLayout() {
        return this.i;
    }

    public EditText getInputView() {
        return this.f13886f;
    }

    public TBSpecificationBtn getSendView() {
        return this.f13887g;
    }

    public TextView getTitleView() {
        return this.k;
    }

    @Override // d.b.h0.w.n
    public int getToolId() {
        return this.l;
    }

    @Override // d.b.h0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.b.h0.w.n
    public void init() {
    }

    public final void n(ArrayList<String> arrayList) {
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
        this.f13886f.getText().insert(this.f13886f.getSelectionStart(), sb2);
    }

    public final void o(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f13886f.getText().insert(this.f13886f.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // d.b.h0.w.b
    public void onAction(d.b.h0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i = aVar.f51523a;
        if (i != 3) {
            if (i != 4) {
                if (i == 6) {
                    Object obj = aVar.f51525c;
                    if (obj == null) {
                        this.f13886f.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.f13886f.setText((CharSequence) null);
                        } else {
                            d.b.i0.k0.b.d(getContext(), (String) aVar.f51525c, new e());
                        }
                    } else if (obj instanceof j) {
                        this.n = null;
                        String str = this.o;
                        if (str != null) {
                            this.f13886f.setHint(str);
                        }
                        Object obj2 = aVar.f51525c;
                        j jVar = (j) obj2;
                        if (TextUtils.isEmpty(((j) obj2).f51607b) && TextUtils.isEmpty(((j) aVar.f51525c).f51606a)) {
                            this.f13886f.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.f51607b)) {
                                d.b.i0.k0.b.d(getContext(), jVar.f51607b, new f(jVar));
                            }
                            if (!TextUtils.isEmpty(jVar.f51606a)) {
                                d.b.i0.k0.b.d(getContext(), jVar.f51606a, new g());
                            }
                        }
                    }
                } else if (i == 17) {
                    Object obj3 = aVar.f51525c;
                    if (obj3 != null && (obj3 instanceof ArrayList)) {
                        n((ArrayList) obj3);
                    }
                } else if (i != 24) {
                    if (i != 39) {
                        if (i != 19) {
                            if (i == 20) {
                                y(true);
                                this.f13888h.setText(getContext().getString(R.string.location_where_are_you));
                            } else if (i != 28) {
                                if (i == 29) {
                                    this.t[3] = false;
                                } else if (i == 44) {
                                    Object obj4 = aVar.f51525c;
                                    if (obj4 != null) {
                                        if (obj4 instanceof String) {
                                            o((String) obj4);
                                        } else if ((obj4 instanceof j) && ((j) obj4).f51606a != null) {
                                            o(((j) obj4).f51606a);
                                        }
                                    }
                                } else if (i != 45) {
                                    switch (i) {
                                        case 9:
                                            if (((Boolean) aVar.f51525c).booleanValue()) {
                                                this.m = null;
                                                this.n = null;
                                                this.f13886f.setText((CharSequence) null);
                                            }
                                            boolean[] zArr = this.t;
                                            zArr[0] = false;
                                            zArr[1] = false;
                                            zArr[2] = false;
                                            zArr[3] = false;
                                            zArr[4] = false;
                                            int[] iArr = this.u;
                                            iArr[0] = 0;
                                            iArr[1] = 0;
                                            break;
                                        case 10:
                                            this.t[2] = true;
                                            break;
                                        case 11:
                                            this.t[2] = false;
                                            break;
                                        case 12:
                                            Object obj5 = aVar.f51525c;
                                            if (obj5 instanceof d.b.h0.w.r.a) {
                                                d.b.h0.w.r.a aVar2 = (d.b.h0.w.r.a) obj5;
                                                WriteImagesInfo writeImagesInfo = aVar2.f51545a;
                                                if (writeImagesInfo != null) {
                                                    if (writeImagesInfo.getChosedFiles() != null) {
                                                        this.u[0] = aVar2.f51545a.getChosedFiles().size();
                                                    } else {
                                                        this.u[0] = 0;
                                                    }
                                                }
                                                if (this.u[0] > 0) {
                                                    this.t[1] = true;
                                                    break;
                                                } else {
                                                    this.t[1] = false;
                                                    break;
                                                }
                                            } else {
                                                return;
                                            }
                                        case 13:
                                            int[] iArr2 = this.u;
                                            iArr2[0] = iArr2[0] - 1;
                                            if (iArr2[0] > 0) {
                                                this.t[1] = true;
                                                break;
                                            } else {
                                                this.t[1] = false;
                                                break;
                                            }
                                    }
                                } else {
                                    Object obj6 = aVar.f51525c;
                                    if (obj6 instanceof String) {
                                        String str2 = (String) obj6;
                                        if (StringUtils.isNull(str2)) {
                                            this.k.setVisibility(8);
                                        } else {
                                            this.k.setVisibility(0);
                                            this.k.setText(str2);
                                        }
                                    } else {
                                        this.k.setVisibility(8);
                                    }
                                }
                            }
                        } else if (aVar.f51525c == null) {
                            y(false);
                        } else {
                            y(true);
                            d.b.h0.w.u.a aVar3 = (d.b.h0.w.u.a) aVar.f51525c;
                            if (aVar3.f51548a == 1) {
                                this.f13888h.setText(getContext().getString(R.string.location_loading));
                            } else if (!TextUtils.isEmpty(aVar3.f51549b)) {
                                this.f13888h.setText(aVar3.f51549b);
                            } else {
                                this.f13888h.setText(getContext().getString(R.string.location_where_are_you));
                            }
                        }
                    }
                    this.t[3] = true;
                } else {
                    v(aVar);
                }
            }
            Object obj7 = aVar.f51525c;
            if (obj7 != null && (!(obj7 instanceof String) || !StringUtils.isNull((String) obj7))) {
                Object obj8 = aVar.f51525c;
                if (!(obj8 instanceof j) || !TextUtils.isEmpty(((j) obj8).f51606a)) {
                    Object obj9 = aVar.f51525c;
                    if (!(obj9 instanceof SpanGroupManager) || !((SpanGroupManager) obj9).w()) {
                        this.t[0] = true;
                    }
                }
            }
            this.t[0] = false;
        } else if (this.f13886f.getSelectionStart() > 0) {
            String substring = this.f13886f.getText().toString().substring(0, this.f13886f.getSelectionStart());
            Matcher matcher = d.b.i0.k0.a.f56419b.matcher(substring);
            if (matcher.find()) {
                this.f13886f.getText().delete(this.f13886f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f13886f.getSelectionStart());
            } else {
                this.f13886f.getText().delete(this.f13886f.getSelectionStart() - 1, this.f13886f.getSelectionStart());
            }
        }
        p(this.v);
    }

    @Override // d.b.h0.w.n
    public void onChangeSkinType(int i) {
        this.f13886f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setViewTextColor(this.f13886f, R.color.CAM_X0105, 2, i);
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i).setShape(0).radius(l.g(getContext(), R.dimen.tbds21)).into(this.f13886f);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0207, i);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
        if (i == 0) {
            d.b.i0.u3.j.e(this.f13886f, R.drawable.edittext_cursor);
            this.f13886f.setHintTextColor(SkinManager.getColor(i, R.color.CAM_X0109));
        } else {
            d.b.i0.u3.j.e(this.f13886f, R.drawable.edittext_cursor_1);
            this.f13886f.setHintTextColor(SkinManager.getColor(i, R.color.CAM_X0109));
        }
        this.f13887g.l(i);
        this.f13888h.l(i);
        d.b.h0.r.u.c.a(this.k).n(R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f13888h) {
            d(new d.b.h0.w.a(18, -1, null));
        }
    }

    public void p(int i) {
        if (i == y) {
            boolean[] zArr = this.t;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.f13887g.setEnabled(false);
            } else {
                this.f13887g.setEnabled(true);
            }
        } else if (i == x) {
            if (this.t[1]) {
                this.f13887g.setEnabled(true);
            } else {
                this.f13887g.setEnabled(false);
            }
        }
    }

    public final void q(Context context) {
        SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
        this.f13886f = spanGroupEditText;
        spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.f13886f.setMaxLines(4);
        this.f13886f.setMinLines(2);
        this.f13886f.setGravity(48);
        this.f13886f.setIncludeFontPadding(false);
        this.f13886f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.f13886f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f13886f.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        d.b.i0.u3.j.e(this.f13886f, R.drawable.edittext_cursor);
        this.f13886f.setLineSpacing(l.g(context, R.dimen.M_T_X002), 1.0f);
        this.f13886f.setPadding(l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004));
        this.f13886f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f13886f.addTextChangedListener(new c());
        this.f13886f.setOnTouchListener(new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X002), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X002));
        this.i.addView(this.f13886f, layoutParams);
    }

    public final void r(Context context) {
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.h(R.color.CAM_X0110);
        bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
        bVar.m(l.g(getContext(), R.dimen.M_H_X002));
        bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X003));
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
        this.f13888h = tBSpecificationBtn;
        tBSpecificationBtn.setLayoutParams(layoutParams);
        this.f13888h.setOnClickListener(this);
        this.f13888h.setConfig(bVar);
        this.f13888h.setTextSize(R.dimen.T_X09);
        this.f13888h.setOnClickListener(this);
        this.f13888h.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.f13888h);
    }

    public final void s() {
        EMTextView eMTextView = new EMTextView(getContext());
        this.k = eMTextView;
        eMTextView.setId(R.id.comment_content);
        this.k.setVisibility(8);
        this.k.setMaxLines(1);
        this.k.setEllipsize(TextUtils.TruncateAt.END);
        this.k.setPadding(l.g(getContext(), R.dimen.M_W_X009), l.g(getContext(), R.dimen.M_H_X005), l.g(getContext(), R.dimen.M_W_X009), l.g(getContext(), R.dimen.M_H_X003));
        this.k.setTextSize(0, l.g(getContext(), R.dimen.T_X08));
        addView(this.k, new LinearLayout.LayoutParams(-1, -2));
    }

    public void setDefaultHint(String str) {
        this.o = str;
    }

    @Override // d.b.h0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f13885e = editorTools;
    }

    public void setHasHint(boolean z) {
    }

    public void setHint(int i) {
        SpanGroupEditText spanGroupEditText = this.f13886f;
        if (spanGroupEditText != null) {
            spanGroupEditText.setHint(getContext().getString(i));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.p = z;
    }

    @Override // d.b.h0.w.n
    public void setToolId(int i) {
        this.l = i;
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText = this.f13886f;
        if (spanGroupEditText != null) {
            spanGroupEditText.setTransLink(z);
        }
    }

    public void setType(int i) {
        this.v = i;
    }

    public final void u(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.f13887g = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f13887g.setEnabled(false);
        this.f13887g.setTextSize(R.dimen.T_X08);
        this.f13887g.setText(context.getString(R.string.pb_send_post));
        this.f13887g.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds150), l.g(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.g(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
        linearLayout.addView(this.f13887g, layoutParams2);
        this.i.addView(linearLayout, layoutParams);
    }

    public final void v(d.b.h0.w.a aVar) {
        Object obj;
        if (aVar == null || (obj = aVar.f51525c) == null || !(obj instanceof t) || ((t) obj).e() == EmotionGroupType.BIG_EMOTION || ((t) aVar.f51525c).e() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        t tVar = (t) aVar.f51525c;
        if (tVar.e() == EmotionGroupType.NET_SUG) {
            x(tVar);
        } else {
            w(tVar);
        }
    }

    public final void w(t tVar) {
        if (!this.p || tVar.e() == EmotionGroupType.LOCAL) {
            String obj = this.f13886f.getText().toString();
            if (this.q && d.b.i0.k0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                d.b.i0.k0.b.b(getContext(), tVar, this.f13886f);
            }
        }
    }

    public final void x(t tVar) {
        if (tVar == null || TextUtils.isEmpty(tVar.b()) || TextUtils.isEmpty(tVar.f())) {
            return;
        }
        String obj = this.f13886f.getText().toString();
        if (this.q && d.b.i0.k0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.b.i0.k0.b.c(getContext(), tVar, this.f13886f);
        }
    }

    public void y(boolean z) {
        TBSpecificationBtn tBSpecificationBtn = this.f13888h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setVisibility(z ? 0 : 8);
        }
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = false;
        this.q = true;
        this.r = true;
        this.s = -1;
        this.t = new boolean[]{false, false, false, false, false};
        this.u = new int[]{0, 0};
        this.v = y;
        this.w = new a();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        s();
        r(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.i = linearLayout;
        linearLayout.setOrientation(0);
        this.i.setMinimumHeight(l.g(context, R.dimen.tbds128));
        addView(this.i, new LinearLayout.LayoutParams(-1, -2));
        q(context);
        u(context);
        this.j = new View(getContext());
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.j);
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText = this.f13886f;
        if (spanGroupEditText != null) {
            spanGroupEditText.setHint(charSequence);
        }
    }
}
