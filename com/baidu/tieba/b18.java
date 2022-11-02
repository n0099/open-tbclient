package com.baidu.tieba;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.fy7;
import com.baidu.tieba.k36;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbTopCommenFloorItemViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b18 extends uz7<PostData, PbTopCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.s g;
    public boolean h;
    public float i;
    public String j;
    public dx7 k;
    public View.OnClickListener l;
    public TbRichTextView.y m;
    public fy7 n;
    public View.OnLongClickListener o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public String t;
    public ng<ConstrainImageLayout> u;
    public ng<TbImageView> v;
    public fy7 w;

    /* JADX WARN: Removed duplicated region for block: B:283:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0930  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048602, this, pbTopCommenFloorItemViewHolder, postData, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.e, R.color.CAM_X0204);
        pbTopCommenFloorItemViewHolder.e.setVisibility(0);
        pbTopCommenFloorItemViewHolder.q.setTag(null);
        pbTopCommenFloorItemViewHolder.q.setUserId(null);
        pbTopCommenFloorItemViewHolder.J.getHeadView().setUserId(null);
        pbTopCommenFloorItemViewHolder.r.setIsHost(false);
        if (postData.s() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(postData.s().getUserId())) {
                pbTopCommenFloorItemViewHolder.r.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    postData.g1((g2 * i3) + (g3 * i3));
                } else if (i3 == 1) {
                    postData.g1(g2 + g3);
                } else {
                    postData.g1(0);
                }
            } else {
                postData.g1((g2 * 2) + (g3 * 2));
                i3 = 2;
            }
            if (pbTopCommenFloorItemViewHolder.K != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbTopCommenFloorItemViewHolder.K.setTag(tShowInfoNew.get(0).getUrl());
                }
                o48 o48Var = this.a;
                if (o48Var != null && o48Var.P() != null) {
                    pbTopCommenFloorItemViewHolder.K.setOnClickListener(this.a.P().d.e);
                }
                int g4 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbTopCommenFloorItemViewHolder.K.h(tShowInfoNew, 3, g4, g4, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        f18.F(pbTopCommenFloorItemViewHolder.h);
                    } else {
                        kw4.d(pbTopCommenFloorItemViewHolder.h).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i5 = postData.b0 ? 2 : 8;
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920b8, postData);
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f0920a1, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.obfuscated_res_0x7f0920dd, postData.s().getUserId());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.obfuscated_res_0x7f0920a1, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.obfuscated_res_0x7f0920e5, postData.s().getUserName());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.obfuscated_res_0x7f0920e7, postData.s().getVirtualUserUrl());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.obfuscated_res_0x7f0920d3, e48.i(this.k, postData, postData.c0, i5, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbTopCommenFloorItemViewHolder.i.setText(dw7.b(this.mContext, pbTopCommenFloorItemViewHolder.h.getText().toString()));
                pbTopCommenFloorItemViewHolder.h.setGravity(16);
                pbTopCommenFloorItemViewHolder.h.setTag(R.id.obfuscated_res_0x7f0920b1, dw7.a());
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbTopCommenFloorItemViewHolder.J.setBigVDimenSize(R.dimen.tbds36);
                pbTopCommenFloorItemViewHolder.J.j(postData.s(), 4);
                pbTopCommenFloorItemViewHolder.q.setVisibility(8);
                pbTopCommenFloorItemViewHolder.J.setVisibility(0);
                pbTopCommenFloorItemViewHolder.J.getHeadView().K(avater, 28, false);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setUserId(postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setUserName(postData.s().getUserName());
                dx7 dx7Var = this.k;
                pbTopCommenFloorItemViewHolder.J.getHeadView().setFid(dx7Var != null ? dx7Var.m() : "");
                dx7 dx7Var2 = this.k;
                pbTopCommenFloorItemViewHolder.J.getHeadView().setFName(dx7Var2 != null ? dx7Var2.n() : "");
                pbTopCommenFloorItemViewHolder.J.getHeadView().setFloor(postData.D());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setTid(postData.M());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setTag(R.id.obfuscated_res_0x7f0920d3, e48.i(this.k, postData, postData.c0, i5, 2));
                pbTopCommenFloorItemViewHolder.J.setTag(R.id.obfuscated_res_0x7f0920a1, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.J.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbTopCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbTopCommenFloorItemViewHolder.q, postData.s(), 4);
                pbTopCommenFloorItemViewHolder.q.setUserId(postData.s().getUserId());
                dx7 dx7Var3 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFid(dx7Var3 != null ? dx7Var3.m() : "");
                dx7 dx7Var4 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFName(dx7Var4 != null ? dx7Var4.n() : "");
                pbTopCommenFloorItemViewHolder.q.setFloor(postData.D());
                pbTopCommenFloorItemViewHolder.q.setTid(postData.M());
                pbTopCommenFloorItemViewHolder.q.setUserName(postData.s().getUserName(), postData.j0());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.obfuscated_res_0x7f0920e7, postData.s().getVirtualUserUrl());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.obfuscated_res_0x7f0920a1, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.obfuscated_res_0x7f0920d3, e48.i(this.k, postData, postData.c0, i5, 2));
                pbTopCommenFloorItemViewHolder.q.setImageDrawable(null);
                pbTopCommenFloorItemViewHolder.q.K(avater, 28, false);
                pbTopCommenFloorItemViewHolder.q.setVisibility(0);
                pbTopCommenFloorItemViewHolder.J.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbTopCommenFloorItemViewHolder.d(true);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(postData.s().getAlaInfo());
                pbTopCommenFloorItemViewHolder.J.getHeadView().setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbTopCommenFloorItemViewHolder.d(false);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(null);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setAlaInfo(null);
            }
            y0(pbTopCommenFloorItemViewHolder.j, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbTopCommenFloorItemViewHolder.k.setImageResource(dx.b(a2));
                    pbTopCommenFloorItemViewHolder.k.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.k.setOnClickListener(new h(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbTopCommenFloorItemViewHolder.k.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        o48 o48Var2 = this.a;
        int level_id = (o48Var2 == null || o48Var2.P() == null || !this.a.P().t0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        dx7 dx7Var5 = this.k;
        if (dx7Var5 != null && dx7Var5.l0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbTopCommenFloorItemViewHolder.I.setVisibility(0);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.I, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbTopCommenFloorItemViewHolder.I.setVisibility(8);
        }
        int i6 = 15;
        if (i3 == 1) {
            i6 = 13;
        } else if (i3 > 1) {
            i6 = 11;
        }
        if (pbTopCommenFloorItemViewHolder.j.getVisibility() == 0) {
            i6 -= 2;
        }
        if (pbTopCommenFloorItemViewHolder.K.getChildCount() > 0) {
            i6 -= 2;
        }
        if (postData.y() > 1000) {
            i6 -= 2;
        }
        if (postData.y() > 10) {
            i6 -= 2;
        }
        if (i6 < 10) {
            if (i3 == 1) {
                i6 += 2;
            } else if (i3 > 1) {
                i6 += 4;
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.j.getVisibility() == 0) {
                i6 += 2;
                pbTopCommenFloorItemViewHolder.j.setVisibility(8);
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.I.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.I.setVisibility(8);
            }
        }
        int m = f18.m();
        String name_show2 = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = mj5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i7 = m - 2;
            if (d2 > i7) {
                name_show2 = mj5.l(name_show2, i7) + StringHelper.STRING_MORE;
            }
        } else if (d2 > m) {
            name_show2 = mj5.l(name_show2, m) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbTopCommenFloorItemViewHolder.i.setText(i0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbTopCommenFloorItemViewHolder.i.setText(name_show2);
        }
        if (((PostData) getItem(i2)).P() == 1 && this.k.Q() != null && this.k.Q().isQuestionThread() && !Q(postData)) {
            ((PostData) getItem(i2)).K0(true);
            pbTopCommenFloorItemViewHolder.q0.setVisibility(0);
            if (((PostData) getItem(i2)).O().booleanValue()) {
                pbTopCommenFloorItemViewHolder.r0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.e0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.r0.postDelayed(new i(this, pbTopCommenFloorItemViewHolder), 3000L);
            } else {
                pbTopCommenFloorItemViewHolder.r0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.e0.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).K0(false);
            pbTopCommenFloorItemViewHolder.q0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.r0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.e0.setVisibility(0);
        }
        ImageView imageView = pbTopCommenFloorItemViewHolder.B;
        if (imageView != null) {
            SparseArray sparseArray = (SparseArray) imageView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbTopCommenFloorItemViewHolder.B.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f0920a4, postData);
        }
        ImageView imageView2 = pbTopCommenFloorItemViewHolder.C;
        if (imageView2 != null) {
            SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbTopCommenFloorItemViewHolder.C.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f0920a4, postData);
        }
        SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.q0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.u0, R.color.CAM_X0105, 1);
        pbTopCommenFloorItemViewHolder.g.post(new j(this, pbTopCommenFloorItemViewHolder, new String[]{name_show2}, postData, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.s0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.s0.setText(postData.s().getDiplayIntro() + "");
        } else {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.s0.setVisibility(8);
        }
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.obfuscated_res_0x7f092087, postData);
        sparseArray3.put(R.id.obfuscated_res_0x7f0920a4, postData);
        sparseArray3.put(R.id.obfuscated_res_0x7f0920a6, view2);
        sparseArray3.put(R.id.obfuscated_res_0x7f0920b5, Integer.valueOf(i2));
        sparseArray3.put(R.id.obfuscated_res_0x7f0920b4, Integer.valueOf(postData.D()));
        sparseArray3.put(R.id.obfuscated_res_0x7f092097, postData.M());
        sparseArray3.put(R.id.obfuscated_res_0x7f091823, pbTopCommenFloorItemViewHolder.d0);
        sparseArray3.put(R.id.obfuscated_res_0x7f091820, pbTopCommenFloorItemViewHolder.B);
        sparseArray3.put(R.id.obfuscated_res_0x7f091821, pbTopCommenFloorItemViewHolder.C);
        dx7 dx7Var6 = this.k;
        ThreadData Q = (dx7Var6 == null || dx7Var6.Q() == null) ? null : this.k.Q();
        if (Q != null && Q.isUgcThreadType()) {
            sparseArray3.put(R.id.obfuscated_res_0x7f09181f, Boolean.TRUE);
        } else {
            sparseArray3.put(R.id.obfuscated_res_0x7f09181f, Boolean.FALSE);
        }
        boolean z7 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        dx7 dx7Var7 = this.k;
        if (dx7Var7 == null || dx7Var7.Y() == 0 || k0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.k.Y() == 1002 || this.k.Y() == 3) ? false : true;
            z2 = (this.k.Y() == 3 || this.k.l0()) ? false : true;
            if (postData != null && postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        dx7 dx7Var8 = this.k;
        if (dx7Var8 != null && dx7Var8.Q() != null && this.k.Q().getAuthor() != null && postData.s() != null) {
            String userId2 = this.k.Q().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z6 = z;
                } else {
                    z2 = false;
                    z3 = false;
                    z6 = false;
                }
                if (postData.D() != 1) {
                    i4 = 1;
                }
                if (!z6) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920d0, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(this.k.Y()));
                    if (postData.s() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f092094, postData.s().getUserName());
                        sparseArray3.put(R.id.obfuscated_res_0x7f092095, postData.s().getName_show());
                        sparseArray3.put(R.id.obfuscated_res_0x7f092096, postData.s().getPortrait());
                    }
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920d0, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920e4, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f09209e, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920e0, postData.s().getUserId());
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920e1, postData.s().getUserName());
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920df, postData.s().getName_show());
                    }
                    if (this.k.Q() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f0920e3, this.k.Q().getId());
                    }
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920e2, postData.M());
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920e4, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ce, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f09209b, Boolean.valueOf(postData.q0()));
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920a7, Integer.valueOf(this.k.Y()));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09208a, Boolean.valueOf(z4));
                    sparseArray3.put(R.id.obfuscated_res_0x7f09208b, Integer.valueOf(i4));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092089, postData.M());
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f0920ce, Boolean.FALSE);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z5));
                pbTopCommenFloorItemViewHolder.r.setTag(sparseArray3);
                pbTopCommenFloorItemViewHolder.t.setTag(sparseArray3);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.D() != 1) {
        }
        if (!z6) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray3.put(R.id.obfuscated_res_0x7f09209f, Boolean.valueOf(z5));
        pbTopCommenFloorItemViewHolder.r.setTag(sparseArray3);
        pbTopCommenFloorItemViewHolder.t.setTag(sparseArray3);
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onClickListener) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, view2) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder b;
        public final /* synthetic */ b18 c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.baidu.tieba.b18$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class View$OnClickListenerC0211a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0211a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        e48.t("c14886");
                        b bVar = this.a.a;
                        b18 b18Var = bVar.c;
                        b18Var.l0(((PostData) b18Var.getItem(bVar.a)).s());
                    }
                }
            }

            /* renamed from: com.baidu.tieba.b18$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0212b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0212b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        b bVar = this.a.a;
                        ((PostData) bVar.c.getItem(bVar.a)).A0();
                        b bVar2 = this.a.a;
                        if (((PostData) bVar2.c.getItem(bVar2.a)).W() <= 0) {
                            b bVar3 = this.a.a;
                            ((PostData) bVar3.c.getItem(bVar3.a)).Q0(Boolean.FALSE);
                            this.a.a.b.r0.setVisibility(8);
                            this.a.a.b.d0.setVisibility(0);
                            this.a.a.b.e0.setVisibility(0);
                        }
                    }
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.d0.getAgreeFlag()) {
                    return;
                }
                b bVar = this.a;
                ((PostData) bVar.c.getItem(bVar.a)).z0();
                b bVar2 = this.a;
                ((PostData) bVar2.c.getItem(bVar2.a)).Q0(Boolean.TRUE);
                this.a.b.d0.setVisibility(8);
                this.a.b.e0.setVisibility(8);
                this.a.b.r0.setVisibility(0);
                this.a.b.r0.setOnClickListener(new View$OnClickListenerC0211a(this));
                this.a.b.r0.postDelayed(new RunnableC0212b(this), 5000L);
            }
        }

        public b(b18 b18Var, int i, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, Integer.valueOf(i), pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b18Var;
            this.a = i;
            this.b = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.Q().getAuthor().getUserId()) || !this.c.k.Q().isQuestionThread() || UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                return;
            }
            if (this.b.d0.getAgreeFlag()) {
                ((PostData) this.c.getItem(this.a)).R0(1);
                this.b.q0.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).K0(true);
                this.b.j.setVisibility(8);
                this.b.d0.postDelayed(new a(this), 900L);
                return;
            }
            ((PostData) this.c.getItem(this.a)).R0(0);
            this.b.r0.setVisibility(8);
            this.b.q0.setVisibility(8);
            this.b.d0.setVisibility(0);
            ((PostData) this.c.getItem(this.a)).K0(false);
            if (((PostData) this.c.getItem(this.a)).Y().booleanValue()) {
                this.b.j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ n28 b;
        public final /* synthetic */ b18 c;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ l b;

            public a(l lVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = lVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    l lVar = this.b;
                    lVar.b.b.a(lVar.c.k, null, this.a, lVar.a.r.getLayoutStrategy());
                }
            }
        }

        public l(b18 b18Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, n28 n28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, pbTopCommenFloorItemViewHolder, n28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b18Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = n28Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.obfuscated_res_0x7f0920a4) instanceof PostData) && (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f0920a4)) != null && this.a.c != null && this.b != null) {
                zg.a().postDelayed(new a(this, postData), 100L);
                String S = this.c.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.c.k.S())) && this.c.k.Q() != null) {
                    S = this.c.k.Q().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.c.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.M()).param("obj_source", this.c.j0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ b18 b;

        public a(b18 b18Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b18Var;
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbTopCommenFloorItemViewHolder = this.a) != null && (agreeView = pbTopCommenFloorItemViewHolder.d0) != null && agreeView.getData() != null) {
                if (view2 == this.a.d0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String S = this.b.k.S();
                if ((StringUtils.isNull(S) || "0".equals(this.b.k.S())) && this.b.k.Q() != null) {
                    S = this.b.k.Q().getNid();
                }
                if (this.a.d0.getData().hasAgree) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                e48.s(i2);
                TiebaStatic.log(new StatisticItem("c13700").param("tid", S).param("fid", this.b.k.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.j0(this.a.d0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        public c(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b18Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    this.a.n.a(view2);
                    return this.a.n.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements og<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public d(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b18Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.mContext);
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements og<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public e(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b18Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.og
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements fy7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b18 a;

        @Override // com.baidu.tieba.fy7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public f(b18 b18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b18Var;
        }

        @Override // com.baidu.tieba.fy7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    if ((view2 instanceof TbListTextView) && this.a.l != null) {
                        this.a.l.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.B6(true);
                        }
                    } else {
                        this.a.n.a(view2);
                        this.a.n.onSingleTapConfirmed(motionEvent);
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.fy7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || ((pbFragment = this.a.b) != null && pbFragment.y5() != null && !this.a.b.y5().I1())) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.R(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.R((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ b18 c;

        public g(b18 b18Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, pbTopCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = b18Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.V.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.O(this.a, !z, this.b.G());
                this.b.N0(!z);
                this.c.o0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.y5() != null && this.c.b.y5().m1() != null && this.c.b.y5().T0() != null && !z && this.a.getView().getTop() < this.c.b.y5().m1().getMeasuredHeight()) {
                    this.c.b.y5().T0().setSelectionFromTop(ListUtils.getPosition(this.c.b.y5().T0().getData(), this.b) + this.c.b.y5().T0().getHeaderViewsCount(), this.c.b.y5().m1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ b18 b;

        public h(b18 b18Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b18Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public i(b18 b18Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r0.setVisibility(8);
                this.a.d0.setVisibility(0);
                this.a.e0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ PostData c;
        public final /* synthetic */ int d;
        public final /* synthetic */ b18 e;

        public j(b18 b18Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, String[] strArr, PostData postData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, pbTopCommenFloorItemViewHolder, strArr, postData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b18Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = strArr;
            this.c = postData;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int width;
            int width2;
            int width3;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.g.getMeasuredWidth();
                boolean h0 = this.e.h0();
                if (!StringUtils.isNull(this.b[0])) {
                    i = this.a.i.getWidth();
                } else {
                    i = 0;
                }
                if (this.a.K.getVisibility() == 8) {
                    width = 0;
                } else {
                    width = this.a.K.getWidth() + f18.c + f18.b;
                }
                if (this.a.k.getVisibility() == 8) {
                    width2 = 0;
                } else {
                    width2 = this.a.k.getWidth() + f18.b;
                }
                if (this.a.I.getVisibility() == 8) {
                    width3 = 0;
                } else {
                    width3 = this.a.I.getWidth() + f18.b;
                }
                int r = f18.r(measuredWidth, width, i, width2, width3, h0);
                if (r < 0 && !StringUtils.isNull(this.b[0])) {
                    this.a.h.setWidth(i + r);
                    z = true;
                } else {
                    this.a.h.setWidth(i);
                    z = false;
                }
                if (this.a.i.getText() == null) {
                    if (z) {
                        this.a.h.setText(this.b[0]);
                        b18 b18Var = this.e;
                        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = this.a;
                        b18Var.t0(pbTopCommenFloorItemViewHolder.h, pbTopCommenFloorItemViewHolder.k);
                    } else {
                        this.a.h.setText(this.b[0]);
                        this.e.u0(this.a.k, false);
                    }
                } else if (z) {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder2 = this.a;
                    pbTopCommenFloorItemViewHolder2.h.setText(pbTopCommenFloorItemViewHolder2.i.getText());
                    b18 b18Var2 = this.e;
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder3 = this.a;
                    b18Var2.t0(pbTopCommenFloorItemViewHolder3.h, pbTopCommenFloorItemViewHolder3.k);
                } else {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder4 = this.a;
                    pbTopCommenFloorItemViewHolder4.h.setText(pbTopCommenFloorItemViewHolder4.i.getText());
                    this.e.u0(this.a.k, false);
                }
                this.e.M(this.c, this.a, r, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ b18 d;

        public k(b18 b18Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b18Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = b18Var;
            this.b = textView;
            this.c = tbImageView;
            this.a = true;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a) {
                return;
            }
            Layout layout = this.b.getLayout();
            if (this.b != null && layout != null) {
                int lineCount = layout.getLineCount() - 1;
                if (layout.getEllipsisCount(lineCount) == 0) {
                    return;
                }
                String charSequence = this.b.getText().toString();
                String substring = charSequence.substring(0, layout.getEllipsisStart(lineCount));
                this.b.setText(charSequence.substring(0, layout.getEllipsisStart(lineCount)).concat(StringHelper.STRING_MORE));
                this.a = false;
                TbImageView tbImageView = this.c;
                if (tbImageView != null && tbImageView.getVisibility() == 0) {
                    if (substring.length() % 2 == 0) {
                        this.d.u0(this.c, false);
                    } else {
                        this.d.u0(this.c, true);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b18(o48 o48Var, BdUniqueId bdUniqueId) {
        super(o48Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o48Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((o48) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = true;
        this.i = 1.0f;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = true;
        this.r = false;
        this.s = 0;
        this.t = null;
        this.u = new ng<>(new d(this), 6, 0);
        this.v = new ng<>(new e(this), 12, 0);
        this.w = new fy7(new f(this));
        if (o48Var != null && o48Var.K() != null) {
            this.q = o48Var.K().R1();
        }
        s(R.dimen.tbds14);
    }

    public final void T(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.v()) && this.h && !h0()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(postData.z())) {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.t.k(ro4.a(postData.z()));
                } else {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.r.k0(postData.v());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
                pbTopCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
                pbTopCommenFloorItemViewHolder.r.k0(null);
                pbTopCommenFloorItemViewHolder.t.setVisibility(8);
            }
            pbTopCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
        }
    }

    public final void U(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && postData != null && (imageView = pbTopCommenFloorItemViewHolder.M) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void W(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && postData != null) {
            ImageView imageView = pbTopCommenFloorItemViewHolder.a0;
            if (postData.a0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void f0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && postData != null) {
            pbTopCommenFloorItemViewHolder.g(postData.R, postData.M(), this.r);
        }
    }

    public final void o0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            TbRichText X = postData.X();
            X.isChanged = true;
            pbTopCommenFloorItemViewHolder.r.setText(X, true, this.g);
        }
    }

    public final void t0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new k(this, textView, tbImageView));
        }
    }

    public final void I(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbTopCommenFloorItemViewHolder) == null) {
            pbTopCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.n);
            pbTopCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbTopCommenFloorItemViewHolder.t.setOnTouchListener(new c(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            this.o = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, yVar) == null) {
            this.m = yVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.j = str;
        }
    }

    public void r(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, dx7Var) == null) {
            this.k = dx7Var;
        }
    }

    public void r0(fy7 fy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, fy7Var) == null) {
            this.n = fy7Var;
        }
    }

    public void s0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, sVar) == null) {
            this.g = sVar;
        }
    }

    public final void x0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof PostData)) {
            return;
        }
        y0(textView, (PostData) tag);
    }

    @Override // com.baidu.tieba.uz7, com.baidu.tieba.jn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        n0(i2, view2, viewGroup, (PostData) obj, (PbTopCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void K(PostData postData) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.M());
                statisticItem.param("pid", postData.M());
                statisticItem.param("tid", postData.g0());
                statisticItem.param("fid", postData.I());
                statisticItem.param("fname", postData.J());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            dx7 dx7Var = this.k;
            if (dx7Var != null) {
                if (dx7Var.y0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        dx7 dx7Var2 = this.k;
                        int i4 = postData.c0;
                        if (postData.b0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        e48.e(uniqueId, dx7Var2, postData, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    dx7 dx7Var3 = this.k;
                    int i5 = postData.c0;
                    if (postData.b0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    e48.e(uniqueId2, dx7Var3, postData, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: m0 */
    public PbTopCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06f9, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0918a3)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f0, (ViewGroup) null));
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = new PbTopCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.q);
            pbTopCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.u);
            pbTopCommenFloorItemViewHolder.u.setImageViewPool(this.v);
            v0(pbTopCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbTopCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.p);
            }
            return pbTopCommenFloorItemViewHolder;
        }
        return (PbTopCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void p0(PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, postData) == null) {
            String userId = postData.s().getUserId();
            dx7 dx7Var = this.k;
            String str2 = "";
            if (dx7Var == null) {
                str = "";
            } else {
                str = dx7Var.m();
            }
            dx7 dx7Var2 = this.k;
            if (dx7Var2 != null) {
                str2 = dx7Var2.n();
            }
            int D = postData.D();
            String M = postData.M();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", M);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, D);
            if (postData.s().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.s().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void L(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) && postData.D == 0 && postData.L) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.M());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            o48 o48Var = this.a;
            if (o48Var != null) {
                int R1 = o48Var.K().R1();
                if (1 != R1 && 2 != R1) {
                    if (3 == R1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaInfo().live_status == 1) {
                p0(postData);
            }
        }
    }

    public final void M(PostData postData, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, postData, pbTopCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.o0() + postData.N()) {
                if (pbTopCommenFloorItemViewHolder.L != null && postData.s() != null) {
                    pbTopCommenFloorItemViewHolder.L.setTag(R.id.obfuscated_res_0x7f0920dd, postData.s().getUserId());
                    o48 o48Var = this.a;
                    if (o48Var != null && o48Var.P() != null) {
                        pbTopCommenFloorItemViewHolder.L.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                    int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbTopCommenFloorItemViewHolder.L.g(iconInfo, i3, g2, g2, xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.Y().booleanValue() && !postData.L()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
            } else if (i2 > postData.N()) {
                if (postData.Y().booleanValue() && !postData.L()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.L.setVisibility(8);
            } else {
                pbTopCommenFloorItemViewHolder.L.setVisibility(8);
                pbTopCommenFloorItemViewHolder.j.setVisibility(8);
            }
        }
    }

    public final void N(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int l2 = ((((xi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                l2 = (l2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().q((int) ((l2 - i3) * this.i));
            tbRichTextView.getLayoutStrategy().H = (l2 - i3) - s(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().p((int) (l2 * 1.618f * this.i));
        }
    }

    public final void O(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbTopCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbTopCommenFloorItemViewHolder.V.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f05f2);
                    return;
                } else {
                    pbTopCommenFloorItemViewHolder.X.setText(str);
                    return;
                }
            }
            pbTopCommenFloorItemViewHolder.V.setVisibility(0);
            pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f0404);
        }
    }

    public final void P(boolean z, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbTopCommenFloorItemViewHolder, postData}) == null) && pbTopCommenFloorItemViewHolder != null && (linearLayout = pbTopCommenFloorItemViewHolder.W) != null && (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(postData.a0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbTopCommenFloorItemViewHolder.W.getLayoutParams();
            if (z) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(0);
                if (z2) {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().l(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams != null) {
                        layoutParams.topMargin = xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().l(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams != null) {
                        layoutParams.topMargin = 0;
                    }
                }
                pbTopCommenFloorItemViewHolder.W.setLayoutParams(layoutParams);
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().l(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            }
            if (pbTopCommenFloorItemViewHolder.l0.getVisibility() != 0 && pbTopCommenFloorItemViewHolder.s0.getVisibility() != 0) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().j(xi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
        }
    }

    public final void b0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048594, this, pbTopCommenFloorItemViewHolder, postData, view2) == null) && pbTopCommenFloorItemViewHolder != null && postData != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = xi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = xi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbTopCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().g(R.drawable.icon_click);
            } else {
                pbTopCommenFloorItemViewHolder.r.k0(null);
                pbTopCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08126e);
            }
            pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().x(R.drawable.pic_video);
            N(pbTopCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(postData.v()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbTopCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbTopCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbTopCommenFloorItemViewHolder.r.setText(postData.X(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbTopCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092087, postData);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a0, Boolean.FALSE);
            sparseArray.put(R.id.obfuscated_res_0x7f0920a1, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.c.setTag(R.id.obfuscated_res_0x7f09209a, sparseArray);
            pbTopCommenFloorItemViewHolder.e0.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public final boolean Q(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postData)) == null) {
            if (this.k.Q() != null && this.k.Q().getAuthor() != null && this.k.Q().getAuthor().getUserId() != null && postData != null && postData.s() != null && postData.s().getUserId() != null) {
                return this.k.Q().getAuthor().getUserId().equals(postData.s().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void S(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, postData) == null) {
            if (postData != null) {
                int i2 = 8;
                if (postData.b0) {
                    i2 = 2;
                }
                StatisticItem i3 = e48.i(this.k, postData, postData.c0, i2, 6);
                postData.d0 = i3;
                if (!ListUtils.isEmpty(postData.a0())) {
                    Iterator<PostData> it = postData.a0().iterator();
                    while (it.hasNext()) {
                        it.next().d0 = i3;
                    }
                }
            }
            e48.t("c14887");
        }
    }

    public final void R(View view2) {
        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbTopCommenFloorItemViewHolder) && (agreeView = (pbTopCommenFloorItemViewHolder = (PbTopCommenFloorItemViewHolder) view2.getTag()).d0) != null && agreeView.getData() != null) {
            pbTopCommenFloorItemViewHolder.d0.setAgreeSource(2);
            pbTopCommenFloorItemViewHolder.d0.K();
        }
    }

    public final String j0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.obfuscated_res_0x7f0918c2);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.obfuscated_res_0x7f0918c2);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void l0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && postData != null) {
            String str = null;
            boolean z2 = true;
            if (postData.s() != null) {
                str = postData.s().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z = true;
                    i55 T = postData.T();
                    z2 = (T != null || StringUtils.isNull(T.b()) || (dx7Var = this.k) == null || dx7Var.l0()) ? false : false;
                    pbTopCommenFloorItemViewHolder.m.setVisibility(8);
                    if (z2 && !z) {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(8);
                    } else {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.h0()), "yyyy"))) {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(postData.h0()));
                    } else {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(postData.h0()));
                    }
                    if (!z) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        TextView textView = pbTopCommenFloorItemViewHolder.o;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1542) + str);
                    } else if (z2) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        if (postData.a0) {
                            pbTopCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(T.b(), 7, StringHelper.STRING_MORE));
                        } else {
                            pbTopCommenFloorItemViewHolder.o.setText(T.b());
                        }
                    } else {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    TextView textView2 = pbTopCommenFloorItemViewHolder.g0;
                    textView2.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
                }
            }
            z = false;
            i55 T2 = postData.T();
            if (T2 != null) {
            }
            pbTopCommenFloorItemViewHolder.m.setVisibility(8);
            if (z2) {
            }
            pbTopCommenFloorItemViewHolder.n.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.h0()), "yyyy"))) {
            }
            if (!z) {
            }
            TextView textView22 = pbTopCommenFloorItemViewHolder.g0;
            textView22.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    public final void q0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048618, this, pbTopCommenFloorItemViewHolder, i2) == null) {
            pbTopCommenFloorItemViewHolder.c.setOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.c.setOnLongClickListener(this.o);
            if (this.a.P() != null && this.a.P().getPageContext() != null && this.a.P().getPageContext().getOrignalPage() != null) {
                l28 l28Var = this.a.P().d;
                pbTopCommenFloorItemViewHolder.h.setOnClickListener(l28Var.b);
                pbTopCommenFloorItemViewHolder.q.setOnClickListener(l28Var.b);
                pbTopCommenFloorItemViewHolder.m0.setOnClickListener(l28Var.d);
                pbTopCommenFloorItemViewHolder.l0.setOnClickListener(l28Var.d);
                pbTopCommenFloorItemViewHolder.J.setOnClickListener(l28Var.b);
                pbTopCommenFloorItemViewHolder.J.getHeadView().setOnClickListener(l28Var.b);
                pbTopCommenFloorItemViewHolder.r.setOnLongClickListener(this.o);
                pbTopCommenFloorItemViewHolder.r.setOnTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.r.setOnImageClickListener(this.m);
                pbTopCommenFloorItemViewHolder.r.setOnImageTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setOnEmotionClickListener(l28Var.f);
                pbTopCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.l);
                pbTopCommenFloorItemViewHolder.N.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.O.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.Q.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.p.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.e0.setOnClickListener(this.l);
                n28 n28Var = this.a.P().e;
                pbTopCommenFloorItemViewHolder.B.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.C.setOnClickListener(new l(this, pbTopCommenFloorItemViewHolder, n28Var));
                pbTopCommenFloorItemViewHolder.d0.A = new a(this, pbTopCommenFloorItemViewHolder);
                pbTopCommenFloorItemViewHolder.d0.setAfterClickListener(new b(this, i2, pbTopCommenFloorItemViewHolder));
            }
        }
    }

    public final void X(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048590, this, pbTopCommenFloorItemViewHolder, postData, view2, i2) == null) && pbTopCommenFloorItemViewHolder != null && postData != null) {
            pbTopCommenFloorItemViewHolder.v.setVisibility(8);
            pbTopCommenFloorItemViewHolder.c0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.f0.setVisibility(8);
            g0(pbTopCommenFloorItemViewHolder, postData, view2, i2);
            U(pbTopCommenFloorItemViewHolder, postData);
            Y(pbTopCommenFloorItemViewHolder, postData);
            b0(pbTopCommenFloorItemViewHolder, postData, view2);
            V(pbTopCommenFloorItemViewHolder, postData);
            d0(pbTopCommenFloorItemViewHolder, postData);
            Z(pbTopCommenFloorItemViewHolder, postData);
            w0(pbTopCommenFloorItemViewHolder, postData);
            e0(pbTopCommenFloorItemViewHolder, postData);
            T(pbTopCommenFloorItemViewHolder, postData);
            W(pbTopCommenFloorItemViewHolder, postData);
            c0(pbTopCommenFloorItemViewHolder, postData);
            f0(pbTopCommenFloorItemViewHolder, postData);
            a0(pbTopCommenFloorItemViewHolder, postData);
        }
    }

    public final void Y(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && postData != null && postData.q() != null) {
            postData.q().threadId = this.a.K().m2();
            postData.q().objType = 1;
            postData.q().isInPost = true;
            ThreadData threadData = null;
            dx7 dx7Var = this.k;
            if (dx7Var != null && dx7Var.Q() != null) {
                threadData = this.k.Q();
            }
            pbTopCommenFloorItemViewHolder.d0.setThreadData(threadData);
            pbTopCommenFloorItemViewHolder.d0.setData(postData.q());
        }
    }

    public final void Z(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.T != null && pbTopCommenFloorItemViewHolder.Q != null) {
            if (postData != null && (alaLiveInfoCoreData = postData.S) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbTopCommenFloorItemViewHolder.T.setText(postData.S.liveTitle);
                pbTopCommenFloorItemViewHolder.Q.setTag(postData.S);
                pbTopCommenFloorItemViewHolder.Q.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbTopCommenFloorItemViewHolder.Q.setVisibility(8);
        }
    }

    public final void e0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData.H() != 2 && postData.H() != 4) {
                pbTopCommenFloorItemViewHolder.W.setVisibility(8);
                pbTopCommenFloorItemViewHolder.V.setVisibility(0);
                P(false, pbTopCommenFloorItemViewHolder, postData);
            } else {
                pbTopCommenFloorItemViewHolder.W.setOnClickListener(new g(this, pbTopCommenFloorItemViewHolder, postData));
                pbTopCommenFloorItemViewHolder.W.setVisibility(0);
                O(pbTopCommenFloorItemViewHolder, postData.t0(), postData.G());
                P(true, pbTopCommenFloorItemViewHolder, postData);
            }
            o0(pbTopCommenFloorItemViewHolder, postData);
        }
    }

    public final void u0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048623, this, tbImageView, z) != null) || tbImageView == null) {
            return;
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
            layoutParams.setMargins(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds_16), xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
            tbImageView.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        layoutParams2.setMargins(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        tbImageView.setLayoutParams(layoutParams2);
    }

    public final void a0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData.c0() != 0) {
                pbTopCommenFloorItemViewHolder.p.setVisibility(0);
                TextView textView = pbTopCommenFloorItemViewHolder.p;
                textView.setText("查看全部" + postData.c0() + "条数据");
                return;
            }
            pbTopCommenFloorItemViewHolder.p.setVisibility(8);
        }
    }

    public final void c0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, pbTopCommenFloorItemViewHolder, postData) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.c != null) {
            o48 o48Var = this.a;
            if (o48Var != null && o48Var.K() != null && StringHelper.equals(this.a.K().t1(), postData.M())) {
                SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final SpannableStringBuilder i0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new k36.a(str, R.drawable.pic_smalldot_title));
                return k36.h(this.a.P(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void d0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.d0() != null && postData.s() != null && !h0()) {
                TbRichText X = postData.X();
                if (X != null && StringUtils.isNull(X.toString()) && StringUtils.isNull(postData.v())) {
                    z = true;
                } else {
                    z = false;
                }
                if (postData.s().getSmallTailThemeData() != null) {
                    str = postData.s().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbTopCommenFloorItemViewHolder.N.setTag(R.id.obfuscated_res_0x7f0920b7, str);
                pbTopCommenFloorItemViewHolder.O.setTag(R.id.obfuscated_res_0x7f0920b7, str);
                l58.c(postData.d0(), pbTopCommenFloorItemViewHolder.N, pbTopCommenFloorItemViewHolder.O, pbTopCommenFloorItemViewHolder.P, false, true, z, postData.s().getSmallTailThemeData());
                return;
            }
            pbTopCommenFloorItemViewHolder.N.setVisibility(8);
            pbTopCommenFloorItemViewHolder.O.setVisibility(8);
        }
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            dx7 dx7Var = this.k;
            if (dx7Var != null && dx7Var.Q() != null) {
                return this.k.Q().isQuestionThread();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            dx7 dx7Var = this.k;
            if (dx7Var != null && dx7Var.Q() != null) {
                return this.k.Q().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View n0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbTopCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbTopCommenFloorItemViewHolder);
            v0(pbTopCommenFloorItemViewHolder);
            q0(pbTopCommenFloorItemViewHolder, i2);
            I(pbTopCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.c0 = i2 + 1;
                L(postData2);
                K(postData2);
                postData2.k1();
                S(postData2);
                X(pbTopCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void v0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, pbTopCommenFloorItemViewHolder) != null) || pbTopCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbTopCommenFloorItemViewHolder.a != skinType) {
            x0(pbTopCommenFloorItemViewHolder.j);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    f18.F(pbTopCommenFloorItemViewHolder.h);
                } else {
                    kw4.d(pbTopCommenFloorItemViewHolder.h).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.H, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.t0, R.color.CAM_X0105, 1);
            pbTopCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbTopCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.getColor(R.color.CAM_X0304);
            pbTopCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.T, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.R, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.Q, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.S, R.color.CAM_X0109);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.U, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.X, (int) R.color.CAM_X0107);
            if (pbTopCommenFloorItemViewHolder.V.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f0404);
            } else {
                dx7 dx7Var = this.k;
                if (dx7Var != null && StringUtils.isNull(dx7Var.k())) {
                    pbTopCommenFloorItemViewHolder.X.setText(this.k.k());
                } else {
                    pbTopCommenFloorItemViewHolder.X.setText(R.string.obfuscated_res_0x7f0f05f2);
                }
            }
            pbTopCommenFloorItemViewHolder.c(skinType);
            WebPManager.setPureDrawable(pbTopCommenFloorItemViewHolder.e0, R.drawable.obfuscated_res_0x7f08099d, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbTopCommenFloorItemViewHolder.b();
        }
        pbTopCommenFloorItemViewHolder.a = skinType;
    }

    public void w0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.l0() != null) {
                VirtualImageCustomFigure l0 = postData.l0();
                pbTopCommenFloorItemViewHolder.m0.setHeadImageViewResource(l0.getFigureUrl());
                pbTopCommenFloorItemViewHolder.m0.setTid(postData.M());
                pbTopCommenFloorItemViewHolder.m0.setLocate(j18.c);
                pbTopCommenFloorItemViewHolder.m0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(l0.getBackGroundType())) {
                    str = l0.getBackgroundValue();
                    pbTopCommenFloorItemViewHolder.m0.setHeadImageBackgroundColorResource(l0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(l0.getBackGroundType())) {
                    pbTopCommenFloorItemViewHolder.m0.setHeadImageBackgroundResource(l0.getBackgroundValue());
                }
                pbTopCommenFloorItemViewHolder.m0.e(postData.s());
                pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.n0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f0920dd, postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f0920e5, postData.s().getUserName());
                pbTopCommenFloorItemViewHolder.f();
                pbTopCommenFloorItemViewHolder.v0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.v0.playAnimation();
            } else {
                pbTopCommenFloorItemViewHolder.n0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f0920dd, null);
                pbTopCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f0920e5, null);
                pbTopCommenFloorItemViewHolder.k0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.v0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.v0.pauseAnimation();
            }
            if (postData.m0() != null && !TextUtils.isEmpty(postData.m0().getIcon())) {
                pbTopCommenFloorItemViewHolder.l0.setData(postData.m0(), false, str);
                pbTopCommenFloorItemViewHolder.l0.setVisibility(0);
                if (pbTopCommenFloorItemViewHolder.o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.o0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbTopCommenFloorItemViewHolder.o0.setLayoutParams(marginLayoutParams);
                }
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f0920dd, postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f0920e5, postData.s().getUserName());
                this.s = j18.d;
                this.t = pbTopCommenFloorItemViewHolder.l0.getData();
                pbTopCommenFloorItemViewHolder.m0.setWithBubble(this.s);
                pbTopCommenFloorItemViewHolder.m0.setBubbleName(this.t);
                pbTopCommenFloorItemViewHolder.m0.setVirtualHeadUid(postData.s().getUserId());
            } else {
                if (pbTopCommenFloorItemViewHolder.o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.o0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbTopCommenFloorItemViewHolder.o0.setLayoutParams(marginLayoutParams2);
                }
                pbTopCommenFloorItemViewHolder.l0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f0920e5, null);
                pbTopCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f0920dd, null);
                int i2 = j18.e;
                this.s = i2;
                pbTopCommenFloorItemViewHolder.m0.setWithBubble(i2);
            }
            if (pbTopCommenFloorItemViewHolder.m0.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.m0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (pbTopCommenFloorItemViewHolder.n0.getVisibility() == 0) {
                layoutParams.setMargins(0, xi.g(this.mContext, R.dimen.M_H_X005), 0, xi.g(this.mContext, R.dimen.tbds5));
            } else {
                layoutParams.setMargins(0, xi.g(this.mContext, R.dimen.M_H_X005), 0, xi.g(this.mContext, R.dimen.tbds_10));
            }
            pbTopCommenFloorItemViewHolder.p0.setLayoutParams(layoutParams);
            if (postData.l0() != null && postData.s() != null) {
                j18.a(2, postData.M(), j18.c, this.s, this.t, postData.s().getUserId());
            }
        }
    }

    public final void y0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            dx7 dx7Var = this.k;
            if (dx7Var != null && dx7Var.l0()) {
                postData.Y0(Boolean.FALSE);
                postData.M0(0);
                textView.setTag(null);
            } else if (postData.s() != null) {
                com.baidu.tbadk.core.data.MetaData s = postData.s();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(s.getUserId())) {
                    postData.Y0(Boolean.TRUE);
                    postData.M0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0893);
                    textView.setBackgroundColor(0);
                    kw4 d2 = kw4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.r0()) {
                    kw4 d3 = kw4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    postData.Y0(Boolean.TRUE);
                    postData.M0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0347);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    kw4 d4 = kw4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    postData.Y0(Boolean.TRUE);
                    postData.M0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.obfuscated_res_0x7f0f0300);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    kw4 d5 = kw4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    postData.Y0(Boolean.TRUE);
                    postData.M0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0301);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    kw4 d6 = kw4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    postData.Y0(Boolean.TRUE);
                    postData.M0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fd);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    kw4 d7 = kw4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    postData.Y0(Boolean.TRUE);
                    postData.M0(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fe);
                } else {
                    postData.Y0(Boolean.FALSE);
                    postData.M0(0);
                }
            } else {
                postData.Y0(Boolean.FALSE);
                postData.M0(0);
            }
        }
    }
}
