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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import d.a.c.e.p.l;
import d.a.m0.s.c.v;
import d.a.m0.s.c.w;
import d.a.m0.w.n;
import d.a.m0.w.w.j;
import d.a.n0.l0.b;
import d.a.n0.w3.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class PbNewInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static int y = 1;
    public static int z;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f12856e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupEditText f12857f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f12858g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f12859h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f12860i;
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
    public List<v> w;
    public Runnable x;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PbNewInputContainer.this.f12857f != null) {
                PbNewInputContainer pbNewInputContainer = PbNewInputContainer.this;
                pbNewInputContainer.d(new d.a.m0.w.a(4, -1, pbNewInputContainer.f12857f.getSpanGroupManager()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbNewInputContainer.this.d(new d.a.m0.w.a(8, -1, null));
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
                PbNewInputContainer.this.m.f54606b = PbNewInputContainer.this.n.toString();
                PbNewInputContainer.this.m.f54605a = PbNewInputContainer.this.f12857f.getText().toString();
                PbNewInputContainer.this.m.f54607c = PbNewInputContainer.this.f12857f.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = PbNewInputContainer.this;
                pbNewInputContainer.d(new d.a.m0.w.a(4, -1, pbNewInputContainer.m));
                return;
            }
            d.a.c.e.m.e.a().removeCallbacks(PbNewInputContainer.this.x);
            d.a.c.e.m.e.a().post(PbNewInputContainer.this.x);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (PbNewInputContainer.this.r) {
                return;
            }
            PbNewInputContainer.this.r = true;
            if (PbNewInputContainer.this.s != -1) {
                PbNewInputContainer.this.f12857f.setSelection(PbNewInputContainer.this.s);
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
                PbNewInputContainer.this.d(new d.a.m0.w.a(5, -1, null));
                PbNewInputContainer.this.f12857f.requestFocus();
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.f {
        public e() {
        }

        @Override // d.a.n0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbNewInputContainer.this.f12857f.setText(spannableStringBuilder);
            PbNewInputContainer.this.f12857f.setSelection(PbNewInputContainer.this.f12857f.getText().length());
            PbNewInputContainer.this.d(new d.a.m0.w.a(5, -1, null));
            PbNewInputContainer.this.requestFocus();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f12866a;

        public f(j jVar) {
            this.f12866a = jVar;
        }

        @Override // d.a.n0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbNewInputContainer.this.n = spannableStringBuilder;
            if (TextUtils.isEmpty(this.f12866a.f54605a)) {
                PbNewInputContainer.this.f12857f.setText("");
                PbNewInputContainer.this.d(new d.a.m0.w.a(5, -1, null));
                PbNewInputContainer.this.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements b.f {
        public g() {
        }

        @Override // d.a.n0.l0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            PbNewInputContainer.this.f12857f.setText(spannableStringBuilder);
            PbNewInputContainer.this.f12857f.setSelection(PbNewInputContainer.this.f12857f.getText().length());
            PbNewInputContainer.this.d(new d.a.m0.w.a(5, -1, null));
            PbNewInputContainer.this.requestFocus();
        }
    }

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    @Override // d.a.m0.w.n
    public void b() {
        if (this.f12857f != null && this.f12860i.getVisibility() == 0) {
            this.f12857f.setFocusable(true);
            this.f12857f.setFocusableInTouchMode(true);
            this.f12857f.requestFocus();
            l.K(getContext(), this.f12857f);
        }
        setVisibility(0);
    }

    @Override // d.a.m0.w.n
    public void d(d.a.m0.w.a aVar) {
        EditorTools editorTools = this.f12856e;
        if (editorTools != null) {
            editorTools.A(aVar);
        }
    }

    public LinearLayout getInputLayout() {
        return this.f12860i;
    }

    public EditText getInputView() {
        return this.f12857f;
    }

    public TBSpecificationBtn getSendView() {
        return this.f12858g;
    }

    public TextView getTitleView() {
        return this.k;
    }

    @Override // d.a.m0.w.n
    public int getToolId() {
        return this.l;
    }

    @Override // d.a.m0.w.n
    public void hide() {
        setVisibility(8);
    }

    @Override // d.a.m0.w.n
    public void init() {
    }

    public final void n(ArrayList<String> arrayList) {
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
        this.f12857f.getText().insert(this.f12857f.getSelectionStart(), sb2);
    }

    public final void o(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f12857f.getText().insert(this.f12857f.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // d.a.m0.w.b
    public void onAction(d.a.m0.w.a aVar) {
        if (aVar == null) {
            return;
        }
        int i2 = aVar.f54518a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 6) {
                    Object obj = aVar.f54520c;
                    if (obj == null) {
                        this.f12857f.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.f12857f.setText((CharSequence) null);
                        } else {
                            d.a.n0.l0.b.d(getContext(), (String) aVar.f54520c, new e());
                        }
                    } else if (obj instanceof j) {
                        this.n = null;
                        String str = this.o;
                        if (str != null) {
                            this.f12857f.setHint(str);
                        }
                        Object obj2 = aVar.f54520c;
                        j jVar = (j) obj2;
                        if (TextUtils.isEmpty(((j) obj2).f54606b) && TextUtils.isEmpty(((j) aVar.f54520c).f54605a)) {
                            this.f12857f.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.f54606b)) {
                                d.a.n0.l0.b.d(getContext(), jVar.f54606b, new f(jVar));
                            }
                            if (!TextUtils.isEmpty(jVar.f54605a)) {
                                d.a.n0.l0.b.d(getContext(), jVar.f54605a, new g());
                            }
                        }
                    }
                } else if (i2 == 17) {
                    Object obj3 = aVar.f54520c;
                    if (obj3 != null && (obj3 instanceof ArrayList)) {
                        n((ArrayList) obj3);
                    }
                } else if (i2 != 24) {
                    if (i2 != 39) {
                        if (i2 != 19) {
                            if (i2 == 20) {
                                y(true);
                                this.f12859h.setText(getContext().getString(R.string.location_where_are_you));
                            } else if (i2 != 28) {
                                if (i2 == 29) {
                                    this.t[3] = false;
                                } else if (i2 == 44) {
                                    Object obj4 = aVar.f54520c;
                                    if (obj4 != null) {
                                        if (obj4 instanceof String) {
                                            o((String) obj4);
                                        } else if ((obj4 instanceof j) && ((j) obj4).f54605a != null) {
                                            o(((j) obj4).f54605a);
                                        }
                                    }
                                } else if (i2 != 45) {
                                    switch (i2) {
                                        case 9:
                                            for (v vVar : this.w) {
                                                q(vVar.a());
                                            }
                                            this.w.clear();
                                            if (((Boolean) aVar.f54520c).booleanValue()) {
                                                this.m = null;
                                                this.n = null;
                                                this.f12857f.setText((CharSequence) null);
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
                                            Object obj5 = aVar.f54520c;
                                            if (obj5 instanceof d.a.m0.w.r.a) {
                                                d.a.m0.w.r.a aVar2 = (d.a.m0.w.r.a) obj5;
                                                WriteImagesInfo writeImagesInfo = aVar2.f54541a;
                                                if (writeImagesInfo != null) {
                                                    if (writeImagesInfo.getChosedFiles() != null) {
                                                        this.u[0] = aVar2.f54541a.getChosedFiles().size();
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
                                    Object obj6 = aVar.f54520c;
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
                        } else if (aVar.f54520c == null) {
                            y(false);
                        } else {
                            y(true);
                            d.a.m0.w.u.a aVar3 = (d.a.m0.w.u.a) aVar.f54520c;
                            if (aVar3.f54544a == 1) {
                                this.f12859h.setText(getContext().getString(R.string.location_loading));
                            } else if (!TextUtils.isEmpty(aVar3.f54545b)) {
                                this.f12859h.setText(aVar3.f54545b);
                            } else {
                                this.f12859h.setText(getContext().getString(R.string.location_where_are_you));
                            }
                        }
                    }
                    this.t[3] = true;
                } else {
                    v(aVar);
                }
            }
            Object obj7 = aVar.f54520c;
            if (obj7 != null && (!(obj7 instanceof String) || !StringUtils.isNull((String) obj7))) {
                Object obj8 = aVar.f54520c;
                if (!(obj8 instanceof j) || !TextUtils.isEmpty(((j) obj8).f54605a)) {
                    Object obj9 = aVar.f54520c;
                    if (!(obj9 instanceof SpanGroupManager) || !((SpanGroupManager) obj9).w()) {
                        this.t[0] = true;
                    }
                }
            }
            this.t[0] = false;
        } else if (this.f12857f.getSelectionStart() > 0) {
            String substring = this.f12857f.getText().toString().substring(0, this.f12857f.getSelectionStart());
            Matcher matcher = d.a.n0.l0.a.f60843b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.f12857f.getText().toString().substring(this.f12857f.getSelectionStart() - length, this.f12857f.getSelectionStart());
                Iterator<v> it = this.w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    v next = it.next();
                    if (next.c().equals(substring2)) {
                        this.w.remove(next);
                        break;
                    }
                }
                this.f12857f.getText().delete(this.f12857f.getSelectionStart() - length, this.f12857f.getSelectionStart()).toString();
            } else {
                this.f12857f.getText().delete(this.f12857f.getSelectionStart() - 1, this.f12857f.getSelectionStart());
            }
        }
        p(this.v);
    }

    @Override // d.a.m0.w.n
    public void onChangeSkinType(int i2) {
        this.f12857f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        SkinManager.setViewTextColor(this.f12857f, R.color.CAM_X0105, 2, i2);
        TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(l.g(getContext(), R.dimen.tbds21)).into(this.f12857f);
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0207, i2);
        SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
        if (i2 == 0) {
            i.e(this.f12857f, R.drawable.edittext_cursor);
            this.f12857f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
        } else {
            i.e(this.f12857f, R.drawable.edittext_cursor_1);
            this.f12857f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
        }
        this.f12858g.l(i2);
        this.f12859h.l(i2);
        d.a.m0.r.u.c.d(this.k).s(R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f12859h) {
            d(new d.a.m0.w.a(18, -1, null));
        }
    }

    public void p(int i2) {
        if (i2 == z) {
            boolean[] zArr = this.t;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.f12858g.setEnabled(false);
            } else {
                this.f12858g.setEnabled(true);
            }
        } else if (i2 == y) {
            if (this.t[1]) {
                this.f12858g.setEnabled(true);
            } else {
                this.f12858g.setEnabled(false);
            }
        }
    }

    public final void q(w wVar) {
        StatisticItem statisticItem = new StatisticItem("c14122");
        statisticItem.param("fid", wVar.f54211a).param("tid", wVar.f54212b).param("uid", wVar.f54213c).param("obj_type", wVar.f54214d).param("obj_source", wVar.f54215e).param("obj_locate", wVar.f54216f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, wVar.f54218h);
        TiebaStatic.log(statisticItem);
    }

    public final void r(Context context) {
        SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
        this.f12857f = spanGroupEditText;
        spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.f12857f.setMaxLines(4);
        this.f12857f.setMinLines(2);
        this.f12857f.setGravity(48);
        this.f12857f.setIncludeFontPadding(false);
        this.f12857f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.f12857f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.f12857f.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        i.e(this.f12857f, R.drawable.edittext_cursor);
        this.f12857f.setLineSpacing(l.g(context, R.dimen.M_T_X002), 1.0f);
        this.f12857f.setPadding(l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004));
        this.f12857f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.f12857f.addTextChangedListener(new c());
        this.f12857f.setOnTouchListener(new d());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X002), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X002));
        this.f12860i.addView(this.f12857f, layoutParams);
    }

    public final void s(Context context) {
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
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
        this.f12859h = tBSpecificationBtn;
        tBSpecificationBtn.setLayoutParams(layoutParams);
        this.f12859h.setOnClickListener(this);
        this.f12859h.setConfig(bVar);
        this.f12859h.setTextSize(R.dimen.T_X09);
        this.f12859h.setOnClickListener(this);
        this.f12859h.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.f12859h);
    }

    public void setDefaultHint(String str) {
        this.o = str;
    }

    @Override // d.a.m0.w.n
    public void setEditorTools(EditorTools editorTools) {
        this.f12856e = editorTools;
    }

    public void setHasHint(boolean z2) {
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText = this.f12857f;
        if (spanGroupEditText != null) {
            spanGroupEditText.setHint(getContext().getString(i2));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z2) {
        this.p = z2;
    }

    @Override // d.a.m0.w.n
    public void setToolId(int i2) {
        this.l = i2;
    }

    public void setTransLink(boolean z2) {
        SpanGroupEditText spanGroupEditText = this.f12857f;
        if (spanGroupEditText != null) {
            spanGroupEditText.setTransLink(z2);
        }
    }

    public void setType(int i2) {
        this.v = i2;
    }

    public final void t() {
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

    public final void u(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
        bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
        TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
        this.f12858g = tBSpecificationBtn;
        tBSpecificationBtn.setConfig(bVar);
        this.f12858g.setEnabled(false);
        this.f12858g.setTextSize(R.dimen.T_X08);
        this.f12858g.setText(context.getString(R.string.pb_send_post));
        this.f12858g.setOnClickListener(new b());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds150), l.g(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.g(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
        linearLayout.addView(this.f12858g, layoutParams2);
        this.f12860i.addView(linearLayout, layoutParams);
    }

    public final void v(d.a.m0.w.a aVar) {
        Object obj;
        if (aVar == null || (obj = aVar.f54520c) == null || !(obj instanceof v) || ((v) obj).f() == EmotionGroupType.BIG_EMOTION || ((v) aVar.f54520c).f() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        v vVar = (v) aVar.f54520c;
        if (vVar.f() == EmotionGroupType.NET_SUG) {
            x(vVar);
        } else {
            w(vVar);
        }
    }

    public final void w(v vVar) {
        if (!this.p || vVar.f() == EmotionGroupType.LOCAL) {
            String obj = this.f12857f.getText().toString();
            if (this.q && d.a.n0.l0.a.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.w.add(vVar);
            d.a.n0.l0.b.b(getContext(), vVar, this.f12857f);
        }
    }

    public final void x(v vVar) {
        if (vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f12857f.getText().toString();
        if (this.q && d.a.n0.l0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
            return;
        }
        this.w.add(vVar);
        d.a.n0.l0.b.c(getContext(), vVar, this.f12857f);
    }

    public void y(boolean z2) {
        TBSpecificationBtn tBSpecificationBtn = this.f12859h;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setVisibility(z2 ? 0 : 8);
        }
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.p = false;
        this.q = true;
        this.r = true;
        this.s = -1;
        this.t = new boolean[]{false, false, false, false, false};
        this.u = new int[]{0, 0};
        this.v = z;
        this.x = new a();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        t();
        s(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f12860i = linearLayout;
        linearLayout.setOrientation(0);
        this.f12860i.setMinimumHeight(l.g(context, R.dimen.tbds128));
        addView(this.f12860i, new LinearLayout.LayoutParams(-1, -2));
        r(context);
        u(context);
        this.j = new View(getContext());
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.j);
        this.w = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText = this.f12857f;
        if (spanGroupEditText != null) {
            spanGroupEditText.setHint(charSequence);
        }
    }
}
