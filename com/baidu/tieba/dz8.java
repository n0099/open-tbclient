package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class dz8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View.OnClickListener b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public ThreadData g;
    public boolean h;
    public boolean i;
    public String j;
    public int k;
    public View.OnLongClickListener l;
    public View.OnClickListener m;

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public TextView c;

        public a(Context context, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0908c3);
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090665);
            this.c = textView;
            textView.setTextSize(0, TbConfig.getContentSizeOfLzl());
            a(TbadkCoreApplication.getInst().getSkinType());
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != this.a) {
                    SkinManager.setBackgroundColor(this.b, R.color.CAM_X0109);
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
                    SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
                    this.c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
                }
                this.a = i;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public View b;
        public LinearLayout c;
        public TextView d;
        public TbRichTextView e;
        public View f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 3;
        }
    }

    public dz8(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = false;
        this.e = false;
        this.f = true;
        this.h = false;
        this.i = false;
        this.j = "";
        this.k = -1;
        this.l = null;
        this.m = null;
        this.a = context;
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06a4, (ViewGroup) null);
            inflate.setTag(new a(this.a, inflate));
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            b bVar = new b();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06a5, (ViewGroup) null);
            bVar.b = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09216b);
            bVar.c = linearLayout;
            if (this.h) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                layoutParams.bottomMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                bVar.c.setLayoutParams(layoutParams);
            }
            bVar.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091609);
            bVar.e = (TbRichTextView) inflate.findViewById(R.id.obfuscated_res_0x7f091827);
            bVar.f = inflate.findViewById(R.id.obfuscated_res_0x7f0908a8);
            bVar.e.getLayoutStrategy().v();
            if (!this.h) {
                bVar.e.getLayoutStrategy().p(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
                bVar.e.getLayoutStrategy().k(0);
                bVar.e.getLayoutStrategy().m(ii.g(this.a, R.dimen.tbds20));
                bVar.e.getLayoutStrategy().n(ii.g(this.a, R.dimen.tbds14));
                bVar.e.setMaxLines(4);
                bVar.e.setTextEllipsize(TextUtils.TruncateAt.END);
                bVar.e.setAddTruncateListener(true);
                bVar.e.setTextSize(TbConfig.getOutterSubpbContentSize());
            } else {
                bVar.e.setTextSize(TbConfig.getContentSizeOfLzl());
            }
            bVar.e.setSubPbPost(true);
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            bVar.e.setIsNeedResizeEmotion(true);
            bVar.e.setTextCenter(true);
            bVar.e.setOnClickListener(this.m);
            bVar.d.setOnClickListener(this.b);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_holder, bVar);
            inflate.setTag(sparseArray);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x025d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(b bVar, sl9 sl9Var, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        SparseArray sparseArray;
        boolean z7;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bVar, sl9Var, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && bVar != null && sl9Var != null) {
            boolean z8 = true;
            boolean z9 = false;
            if (!sl9Var.a0) {
                Context context = this.a;
                if (context instanceof nu8) {
                    nu8 nu8Var = (nu8) context;
                    TbPageContext pageContext = nu8Var.getPageContext();
                    if (sl9Var.q() != null && nu8Var.G(sl9Var.q().getUserId())) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    sl9Var.n1(pageContext, z7);
                }
            }
            if (z3) {
                SkinManager.setBackgroundColor(bVar.b, R.color.CAM_X0204);
            } else {
                bVar.b.setBackgroundResource(0);
            }
            if (sl9Var.y0()) {
                bVar.f.setVisibility(0);
            } else {
                bVar.f.setVisibility(8);
            }
            bVar.e.setPadding(0, 0, 0, 0);
            if (sl9Var.q() != null) {
                String name_show = sl9Var.q().getName_show();
                String userId = sl9Var.q().getUserId();
                String portrait = sl9Var.q().getPortrait();
                SparseArray sparseArray2 = (SparseArray) bVar.b.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.b.setTag(sparseArray2);
                    bVar.e.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_photo_portrait, portrait);
                sparseArray2.put(R.id.tag_clip_board, sl9Var);
                sparseArray2.put(R.id.tag_is_subpb, Boolean.TRUE);
            }
            bVar.e.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0108));
            bVar.e.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            d(sl9Var, this.h);
            TbRichText a0 = sl9Var.a0();
            if (a0 != null) {
                bVar.e.setVoiceViewRes(R.layout.obfuscated_res_0x7f0d0979);
                bVar.e.setIsFromCDN(this.f);
                if (bVar.a != TbadkCoreApplication.getInst().getSkinType()) {
                    a0.isChanged = true;
                }
                bVar.e.setText(a0);
            }
            String userId2 = sl9Var.q().getUserId();
            int i = this.c;
            if (i != 0) {
                if (i != 1002 && i != 3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (this.c != 3 && !this.g.isBjh()) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z4 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = false;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (this.d) {
                if (!this.g.isBjh()) {
                    z5 = true;
                }
                if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = true;
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z9 = true;
                    } else {
                        z8 = z5;
                    }
                    bVar.d.setVisibility(8);
                    sparseArray = (SparseArray) bVar.b.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.b.setTag(sparseArray);
                        bVar.e.setTag(sparseArray);
                    }
                    sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.j);
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.c));
                        if (sl9Var.q() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, sl9Var.q().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, sl9Var.q().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, sl9Var.q().getPortrait());
                        }
                        sparseArray.put(R.id.tag_forbid_user_post_id, sl9Var.O());
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    }
                    sparseArray.put(R.id.tag_forbid_user_post_id, sl9Var.O());
                    sparseArray.put(R.id.tag_clip_board, sl9Var);
                    if (!z6) {
                        if (this.g != null) {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (sl9Var.q() != null) {
                                sparseArray.put(R.id.tag_user_mute_mute_userid, sl9Var.q().getUserId());
                                sparseArray.put(R.id.tag_user_mute_mute_username, sl9Var.q().getUserName());
                                sparseArray.put(R.id.tag_user_mute_mute_nameshow, sl9Var.q().getName_show());
                            }
                            if (this.g.getId() != null) {
                                sparseArray.put(R.id.tag_user_mute_thread_id, this.g.getId());
                            }
                            sparseArray.put(R.id.tag_user_mute_post_id, sl9Var.O());
                        }
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (!z8) {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.c));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z9));
                        sparseArray.put(R.id.tag_del_post_type, 2);
                        sparseArray.put(R.id.tag_del_post_id, sl9Var.O());
                        sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(sl9Var.u0()));
                    } else {
                        sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    }
                    if (this.h && z2 && this.i) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                        layoutParams.topMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070207);
                        layoutParams.bottomMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                        bVar.c.setLayoutParams(layoutParams);
                    }
                    if (this.h && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                        layoutParams2.topMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                        layoutParams2.bottomMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                        bVar.c.setLayoutParams(layoutParams2);
                    }
                    bVar.d.setTag(sparseArray);
                    bVar.e.setTag(sparseArray);
                    bVar.a = TbadkCoreApplication.getInst().getSkinType();
                    bVar.e.setOnLongClickListener(this.l);
                    if (sl9Var == null && sl9Var.q() != null && sl9Var.n() != null) {
                        gz8.b("1", String.valueOf(sl9Var.n().threadId), TbadkCoreApplication.getCurrentAccount(), sl9Var.O(), sl9Var.K(), sl9Var.L());
                        return;
                    }
                    return;
                }
            }
            z6 = false;
            if (userId2 == null) {
            }
            z8 = z5;
            bVar.d.setVisibility(8);
            sparseArray = (SparseArray) bVar.b.getTag();
            if (sparseArray == null) {
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.j);
            if (!z4) {
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, sl9Var.O());
            sparseArray.put(R.id.tag_clip_board, sl9Var);
            if (!z6) {
            }
            if (!z8) {
            }
            if (this.h) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                layoutParams3.topMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070207);
                layoutParams3.bottomMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                bVar.c.setLayoutParams(layoutParams3);
            }
            if (this.h) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) bVar.c.getLayoutParams();
                layoutParams22.topMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                layoutParams22.bottomMargin = ii.g(this.a, R.dimen.obfuscated_res_0x7f070303);
                bVar.c.setLayoutParams(layoutParams22);
            }
            bVar.d.setTag(sparseArray);
            bVar.e.setTag(sparseArray);
            bVar.a = TbadkCoreApplication.getInst().getSkinType();
            bVar.e.setOnLongClickListener(this.l);
            if (sl9Var == null) {
            }
        }
    }

    public final void d(sl9 sl9Var, boolean z) {
        TbRichText a0;
        SpannableStringBuilder c0;
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048579, this, sl9Var, z) != null) || sl9Var == null || (a0 = sl9Var.a0()) == null) {
            return;
        }
        ArrayList<TbRichTextData> S = a0.S();
        if (ListUtils.isEmpty(S)) {
            return;
        }
        TbRichTextData tbRichTextData = S.get(S.size() - 1);
        if (z) {
            int i2 = -1;
            if (tbRichTextData != null) {
                i = tbRichTextData.getType();
            } else {
                i = -1;
            }
            if (i == 1) {
                String str2 = "   " + StringHelper.getFormatTime(sl9Var.l0());
                if (S.size() > 1) {
                    if (S.get(S.size() - 2) != null) {
                        i2 = S.get(S.size() - 2).getType();
                    }
                    if (i2 != i) {
                        str2 = StringHelper.getFormatTime(sl9Var.l0());
                    }
                }
                SpannableStringBuilder c02 = tbRichTextData.c0();
                if (a0.hasAppendTime && c02 != 0 && a0.appendLength <= c02.length()) {
                    c02.delete(c02.length() - a0.appendLength, c02.length());
                }
                str = StringHelper.forceLToR(str2);
                if (c02 != null) {
                    c02.append((CharSequence) str);
                }
                a0.hasAppendTime = true;
                a0.appendLength = str.length();
            } else if (!a0.hasAppendTime) {
                String formatTime = StringHelper.getFormatTime(sl9Var.l0());
                tbRichTextData = new TbRichTextData(1);
                str = StringHelper.forceLToR(formatTime);
                tbRichTextData.R(str);
                a0.hasAppendTime = true;
                a0.appendLength = str.length();
                S.add(tbRichTextData);
            } else {
                str = "";
            }
            SpannableStringBuilder c03 = tbRichTextData.c0();
            if (c03 != null && str.length() <= c03.length()) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109));
                c03.setSpan(absoluteSizeSpan, c03.length() - str.length(), c03.length(), 33);
                c03.setSpan(foregroundColorSpan, c03.length() - str.length(), c03.length(), 33);
                return;
            }
            return;
        }
        if (a0.hasAppendTime && tbRichTextData != null && (c0 = tbRichTextData.c0()) != null && a0.appendLength <= c0.length()) {
            c0.delete(c0.length() - a0.appendLength, c0.length());
        }
        a0.hasAppendTime = false;
        a0.appendLength = 0;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f = z;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.j = str;
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.b = onClickListener;
        }
    }

    public void i(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, threadData) == null) {
            this.g = threadData;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        sl9 sl9Var;
        b bVar;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048586, this, i, view2, viewGroup)) == null) {
            if (getItem(i) instanceof sl9) {
                sl9Var = (sl9) getItem(i);
            } else {
                sl9Var = null;
            }
            sl9 sl9Var2 = sl9Var;
            if (view2 == null) {
                if (sl9Var2.getType() == sl9.X0) {
                    view2 = a();
                } else {
                    view2 = b();
                }
            }
            if ((view2.getTag() instanceof a) && sl9Var2.getType() != sl9.X0) {
                view2 = b();
            }
            if ((view2.getTag() instanceof SparseArray) && sl9Var2.getType() == sl9.X0) {
                view2 = a();
            }
            if ((view2.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view2.getTag()).get(R.id.tag_holder)) != null && sl9Var2 != null) {
                if (!this.e && i + 1 >= getCount()) {
                    z = true;
                } else {
                    z = false;
                }
                if (i == this.k) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z4 = !z;
                if (i == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                c(bVar, sl9Var2, z4, z3, z2);
                if (z2) {
                    this.k = -1;
                }
            }
            if (view2.getTag() instanceof a) {
                ((a) view2.getTag()).a(TbadkCoreApplication.getInst().getSkinType());
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public void j(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.c = i;
            this.d = z;
        }
    }
}
