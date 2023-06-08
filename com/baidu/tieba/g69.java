package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
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
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.s49;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class g69 extends i69<jy9, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s49 A;
    public boolean B;
    public TbRichTextView.u g;
    public boolean h;
    public float i;
    public String j;
    public m39 k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public TbRichTextView.a0 n;
    public s49 o;
    public View.OnLongClickListener p;
    public ka9 q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public kg<ConstrainImageLayout> y;
    public kg<TbImageView> z;

    /* JADX WARN: Removed duplicated region for block: B:224:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x07d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var, View view2, int i2) {
        ThreadData threadData;
        String str;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048602, this, pbCommenFloorItemViewHolder, jy9Var, view2, i2) == null) || pbCommenFloorItemViewHolder == null || jy9Var == null) {
            return;
        }
        if (jy9Var.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (jy9Var.p() != null) {
            String str2 = this.j;
            if (str2 != null && !str2.equals("0") && this.j.equals(jy9Var.p().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = jy9Var.p().getIconInfo();
            ArrayList<IconData> tShowInfoNew = jy9Var.p().getTShowInfoNew();
            int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int g3 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                int size = iconInfo.size();
                if (size > 1) {
                    jy9Var.m1((g2 * size) + (g3 * size));
                } else if (size == 1) {
                    jy9Var.m1(g2 + g3);
                } else {
                    jy9Var.m1(0);
                }
            } else {
                jy9Var.m1((g2 * 2) + (g3 * 2));
            }
            if (pbCommenFloorItemViewHolder.F != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                }
                fb9 fb9Var = this.a;
                if (fb9Var != null && fb9Var.V() != null) {
                    pbCommenFloorItemViewHolder.F.setOnClickListener(this.a.V().c.e);
                }
                int g4 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, g4, g4, vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !jy9Var.p().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        u79.I(pbCommenFloorItemViewHolder.g);
                    } else {
                        o75.d(pbCommenFloorItemViewHolder.g).C(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = jy9Var.p().getAvater();
            int i4 = jy9Var.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, jy9Var.p().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, jy9Var.p().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, jy9Var.p().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, bb9.i(this.k, jy9Var, jy9Var.d0, i4, 2));
            String name_show = jy9Var.p().getName_show();
            String userName = jy9Var.p().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.h.setText(o29.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, o29.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (jy9Var.p().getPendantData() != null && !StringUtils.isNull(jy9Var.p().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.E.i(jy9Var.p());
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.getHeadView().N(avater, 28, false);
                pbCommenFloorItemViewHolder.E.getHeadView().setUserId(jy9Var.p().getUserId());
                pbCommenFloorItemViewHolder.E.getHeadView().setUserName(jy9Var.p().getUserName());
                m39 m39Var = this.k;
                pbCommenFloorItemViewHolder.E.getHeadView().setFid(m39Var != null ? m39Var.l() : "");
                m39 m39Var2 = this.k;
                pbCommenFloorItemViewHolder.E.getHeadView().setFName(m39Var2 != null ? m39Var2.m() : "");
                pbCommenFloorItemViewHolder.E.getHeadView().setFloor(jy9Var.D());
                pbCommenFloorItemViewHolder.E.getHeadView().setTid(jy9Var.O());
                pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, bb9.i(this.k, jy9Var, jy9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.E.i(jy9Var.p());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, jy9Var.p(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(jy9Var.p().getUserId());
                m39 m39Var3 = this.k;
                pbCommenFloorItemViewHolder.p.setFid(m39Var3 != null ? m39Var3.l() : "");
                m39 m39Var4 = this.k;
                pbCommenFloorItemViewHolder.p.setFName(m39Var4 != null ? m39Var4.m() : "");
                pbCommenFloorItemViewHolder.p.setFloor(jy9Var.D());
                pbCommenFloorItemViewHolder.p.setTid(jy9Var.O());
                pbCommenFloorItemViewHolder.p.setUserName(jy9Var.p().getUserName(), jy9Var.o0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, jy9Var.p().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, bb9.i(this.k, jy9Var, jy9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.N(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (jy9Var.p() != null && jy9Var.p().getAlaInfo() != null && jy9Var.p().getAlaUserData() != null && jy9Var.p().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(jy9Var.p().getAlaInfo());
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(jy9Var.p().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
            }
            w0(pbCommenFloorItemViewHolder.i, jy9Var);
            if (TbSingleton.getInstance().isUserGrowthOpen() && jy9Var.p().getUserGrowthData() != null) {
                int a2 = jy9Var.p().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.j.setImageResource(yx.b(a2));
                    pbCommenFloorItemViewHolder.j.setVisibility(0);
                    pbCommenFloorItemViewHolder.j.setOnClickListener(new n(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            threadData = null;
        }
        fb9 fb9Var2 = this.a;
        if (fb9Var2 == null || fb9Var2.V() == null || !this.a.V().z0() || jy9Var.p() == null) {
            str = "";
            i3 = 0;
        } else {
            i3 = jy9Var.p().getLevel_id();
            str = jy9Var.p().getLevelName();
        }
        m39 m39Var5 = this.k;
        if (m39Var5 != null && m39Var5.i0()) {
            i3 = 0;
        }
        if (i3 > 0) {
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setLevel(i3, str);
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
        }
        if (((jy9) getItem(i2)).R() == 1 && this.k.N() != null && this.k.N().isQuestionThread() && !O(jy9Var)) {
            ((jy9) getItem(i2)).Q0(true);
            pbCommenFloorItemViewHolder.w0.setVisibility(0);
            if (((jy9) getItem(i2)).Q().booleanValue()) {
                pbCommenFloorItemViewHolder.x0.setVisibility(0);
                pbCommenFloorItemViewHolder.c0.setVisibility(8);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                pbCommenFloorItemViewHolder.x0.postDelayed(new o(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.x0.setVisibility(8);
                pbCommenFloorItemViewHolder.c0.setVisibility(0);
                pbCommenFloorItemViewHolder.d0.setVisibility(0);
            }
        } else {
            ((jy9) getItem(i2)).Q0(false);
            pbCommenFloorItemViewHolder.w0.setVisibility(8);
            pbCommenFloorItemViewHolder.x0.setVisibility(8);
            pbCommenFloorItemViewHolder.c0.setVisibility(0);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.w0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.v0, R.color.CAM_X0105, 1);
        J(jy9Var, pbCommenFloorItemViewHolder, 2);
        pbCommenFloorItemViewHolder.f.post(new p(this, pbCommenFloorItemViewHolder, (jy9Var.p() == null || jy9Var.p().getName_show() == null) ? "" : jy9Var.p().getName_show()));
        if (!StringUtils.isNull(jy9Var.p().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.y0.setVisibility(0);
            pbCommenFloorItemViewHolder.y0.setText(jy9Var.p().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, jy9Var);
        sparseArray.put(R.id.tag_load_sub_data, jy9Var);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(jy9Var.D()));
        sparseArray.put(R.id.tag_forbid_user_post_id, jy9Var.O());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
        m39 m39Var6 = this.k;
        ThreadData N = (m39Var6 == null || m39Var6.N() == null) ? threadData : this.k.N();
        if (N != null && N.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (jy9Var.p() == null || StringUtils.isNull(jy9Var.p().getVirtualUserUrl())) ? false : true;
        m39 m39Var7 = this.k;
        if (m39Var7 == null || m39Var7.V() == 0 || h0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.k.V() == 1002 || this.k.V() == 3) ? false : true;
            if (this.k.V() == 3 || this.k.i0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (jy9Var != null && jy9Var.p() != null) {
                String userId = jy9Var.p().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        m39 m39Var8 = this.k;
        if (m39Var8 != null && m39Var8.N() != null && this.k.N().getAuthor() != null && jy9Var.p() != null) {
            String userId2 = this.k.N().getAuthor().getUserId();
            String userId3 = jy9Var.p().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z5 = false;
                    z6 = true;
                } else {
                    z5 = true;
                    z6 = false;
                }
                z4 = true;
                z7 = true;
                if (jy9Var != null && jy9Var.p() != null && UtilHelper.isCurrentAccount(jy9Var.p().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i5 = jy9Var.D() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.V()));
                    if (jy9Var.p() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, jy9Var.p().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, jy9Var.p().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, jy9Var.p().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (jy9Var.p() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, jy9Var.p().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, jy9Var.p().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, jy9Var.p().getName_show());
                    }
                    if (this.k.N() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.k.N().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, jy9Var.O());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(jy9Var.v0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.V()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i5));
                    sparseArray.put(R.id.tag_del_post_id, jy9Var.O());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.q.setTag(sparseArray);
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (jy9Var != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (jy9Var.D() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z3));
        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.q.setTag(sparseArray);
        pbCommenFloorItemViewHolder.s.setTag(sparseArray);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, view2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ g69 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            /* renamed from: com.baidu.tieba.g69$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class View$OnClickListenerC0321a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0321a(a aVar) {
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
                        bb9.t("c14886");
                        f fVar = this.a.a;
                        if (fVar.c.getItem(fVar.a) instanceof jy9) {
                            f fVar2 = this.a.a;
                            g69 g69Var = fVar2.c;
                            g69Var.i0(((jy9) g69Var.getItem(fVar2.a)).p());
                        }
                    }
                }
            }

            /* loaded from: classes5.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public b(a aVar) {
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
                        f fVar = this.a.a;
                        if (fVar.c.getItem(fVar.a) instanceof jy9) {
                            f fVar2 = this.a.a;
                            jy9 jy9Var = (jy9) fVar2.c.getItem(fVar2.a);
                            jy9Var.F0();
                            if (jy9Var.Z() <= 0) {
                                jy9Var.W0(Boolean.FALSE);
                                this.a.a.b.x0.setVisibility(8);
                                this.a.a.b.c0.setVisibility(0);
                                this.a.a.b.d0.setVisibility(0);
                            }
                        }
                    }
                }
            }

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.c0.getAgreeFlag()) {
                    return;
                }
                f fVar = this.a;
                ((jy9) fVar.c.getItem(fVar.a)).E0();
                f fVar2 = this.a;
                ((jy9) fVar2.c.getItem(fVar2.a)).W0(Boolean.TRUE);
                this.a.b.c0.setVisibility(8);
                this.a.b.d0.setVisibility(8);
                this.a.b.x0.setVisibility(0);
                this.a.b.x0.setOnClickListener(new View$OnClickListenerC0321a(this));
                this.a.b.x0.postDelayed(new b(this), 5000L);
            }
        }

        public f(g69 g69Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g69Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.N().getAuthor().getUserId()) || !this.c.k.N().isQuestionThread() || UtilHelper.isCurrentAccount(((jy9) this.c.getItem(this.a)).p().getUserId())) {
                return;
            }
            if (this.b.c0.getAgreeFlag()) {
                ((jy9) this.c.getItem(this.a)).X0(1);
                this.b.w0.setVisibility(0);
                ((jy9) this.c.getItem(this.a)).Q0(true);
                this.b.i.setVisibility(8);
                this.b.c0.postDelayed(new a(this), 900L);
                return;
            }
            ((jy9) this.c.getItem(this.a)).X0(0);
            this.b.x0.setVisibility(8);
            this.b.w0.setVisibility(8);
            this.b.c0.setVisibility(0);
            this.b.d0.setVisibility(0);
            ((jy9) this.c.getItem(this.a)).Q0(false);
            if (((jy9) this.c.getItem(this.a)).c0().booleanValue()) {
                this.b.i.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ d99 b;
        public final /* synthetic */ g69 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jy9 a;
            public final /* synthetic */ c b;

            public a(c cVar, jy9 jy9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, jy9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = jy9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.b;
                    cVar.b.b.a(cVar.c.k, null, this.a, cVar.a.q.getLayoutStrategy());
                }
            }
        }

        public c(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, d99 d99Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder, d99Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g69Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = d99Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            jy9 jy9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof jy9) && (jy9Var = (jy9) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                wg.a().postDelayed(new a(this, jy9Var), 100L);
                String P = this.c.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.c.k.P())) && this.c.k.N() != null) {
                    P = this.c.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", jy9Var.O()).param("obj_source", this.c.g0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy9 a;
        public final /* synthetic */ g69 b;

        public a(g69 g69Var, jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, jy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g69Var;
            this.a = jy9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                jy9 jy9Var = this.a;
                if (jy9Var != null && jy9Var.p() != null) {
                    vx5.d(this.b.k.l(), this.a.p().getPortrait(), "3", this.b.b.getContext());
                }
                wx5.c("c15281", this.b.k.l(), "3");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public b(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.y.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ g69 b;

        public d(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g69Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.k.P())) && this.b.k.N() != null) {
                    P = this.b.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.g0(this.a.o)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ g69 b;

        public e(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g69Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                if (view2 == this.a.c0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.k.P())) && this.b.k.N() != null) {
                    P = this.b.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.g0(this.a.c0)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g69 a;

        public g(g69 g69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g69Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    this.a.o.a(view2);
                    return this.a.o.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements lg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g69 a;

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

        public h(g69 g69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g69Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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

    /* loaded from: classes5.dex */
    public class i implements lg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g69 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public i(g69 g69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g69Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.lg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.lg
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
        @Override // com.baidu.tieba.lg
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

    /* loaded from: classes5.dex */
    public class j implements s49.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g69 a;

        @Override // com.baidu.tieba.s49.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public j(g69 g69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g69Var;
        }

        @Override // com.baidu.tieba.s49.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if ((view2 instanceof TbListTextView) && this.a.m != null) {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.L6(false);
                            return true;
                        }
                        return true;
                    }
                    this.a.o.a(view2);
                    this.a.o.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.s49.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.L5() != null && !this.a.b.L5().R1()) || view2.getId() == R.id.obfuscated_res_0x7f090b4c)) {
                    return true;
                }
                if (!(view2 instanceof FrameLayout)) {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (!(parent instanceof FrameLayout)) {
                            parent = parent.getParent();
                            i++;
                        } else {
                            this.a.P((FrameLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.P(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public k(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            TBLottieAnimationView tBLottieAnimationView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (tBLottieAnimationView = this.a.z0) != null) {
                tBLottieAnimationView.setVisibility(8);
                this.a.z0.pauseAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jy9 a;
        public final /* synthetic */ g69 b;

        public l(g69 g69Var, jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, jy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g69Var;
            this.a = jy9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.p() != null && this.a.p().getPortrait() != null && !TextUtils.isEmpty(this.a.p().getPortrait())) {
                String str2 = null;
                if (this.a.q0() != null) {
                    str2 = this.a.q0().getFigureUrl();
                    str = this.a.q0().getBackgroundValue();
                } else {
                    str = null;
                }
                b36.a(this.b.a.V().getPageContext(), this.a.p().getPortrait(), str2, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ jy9 b;
        public final /* synthetic */ g69 c;

        public m(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder, jy9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g69Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = jy9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.R.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.M(this.a, !z, this.b.H());
                this.b.T0(!z);
                this.c.l0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.L5() != null && this.c.b.L5().r1() != null && this.c.b.L5().a1() != null && !z && this.a.getView().getTop() < this.c.b.L5().r1().getMeasuredHeight()) {
                    this.c.b.L5().a1().setSelectionFromTop(ListUtils.getPosition(this.c.b.L5().a1().getData(), this.b) + this.c.b.L5().a1().getHeaderViewsCount(), this.c.b.L5().r1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ g69 b;

        public n(g69 g69Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g69Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            qx4.v(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public o(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.x0.setVisibility(8);
                this.a.c0.setVisibility(0);
                this.a.d0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public p(g69 g69Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g69Var, pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.a.F);
                arrayList.add(this.a.i);
                arrayList.add(this.a.j);
                arrayList.add(this.a.w0);
                arrayList.add(this.a.D);
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                ux5.c(measuredWidth, str, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.D, arrayList, pbCommenFloorItemViewHolder.G);
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder2 = this.a;
                wx5.a(pbCommenFloorItemViewHolder2.g, pbCommenFloorItemViewHolder2.F, pbCommenFloorItemViewHolder2.j, pbCommenFloorItemViewHolder2.D, pbCommenFloorItemViewHolder2.G, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g69(fb9 fb9Var, BdUniqueId bdUniqueId) {
        super(fb9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fb9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((fb9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.p = null;
        this.q = null;
        this.s = true;
        this.u = true;
        this.v = false;
        this.w = 0;
        this.x = null;
        this.y = new kg<>(new h(this), 6, 0);
        this.z = new kg<>(new i(this), 12, 0);
        this.A = new s49(new j(this));
        this.B = false;
        if (fb9Var != null && fb9Var.Q() != null) {
            this.t = fb9Var.Q().x1();
        }
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.o);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new g(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.h = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, a0Var) == null) {
            this.n = a0Var;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.s = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.j = str;
        }
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.v = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.r = z;
        }
    }

    public void r(m39 m39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, m39Var) == null) {
            this.k = m39Var;
        }
    }

    public void r0(s49 s49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, s49Var) == null) {
            this.o = s49Var;
        }
    }

    public void s0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, uVar) == null) {
            this.g = uVar;
        }
    }

    public final void v0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048626, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof jy9)) {
            return;
        }
        w0(textView, (jy9) tag);
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null && (imageView = pbCommenFloorItemViewHolder.H) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            int i2 = 0;
            if (pbCommenFloorItemViewHolder.X.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                ImageView imageView = pbCommenFloorItemViewHolder.W;
                if (!jy9Var.b0) {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
            }
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            pbCommenFloorItemViewHolder.h(jy9Var.S, jy9Var.O(), this.v);
        }
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048610, this, pbCommenFloorItemViewHolder, jy9Var) == null) {
            TbRichText a0 = jy9Var.a0();
            if (a0 != null) {
                a0.isChanged = true;
            }
            pbCommenFloorItemViewHolder.q.setText(a0, true, this.g);
        }
    }

    public final void H(jy9 jy9Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jy9Var) == null) {
            if (jy9Var != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", jy9Var.O());
                statisticItem.param("pid", jy9Var.O());
                statisticItem.param("tid", jy9Var.k0());
                statisticItem.param("fid", jy9Var.J());
                statisticItem.param("fname", jy9Var.K());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            m39 m39Var = this.k;
            if (m39Var != null) {
                if (m39Var.w0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        m39 m39Var2 = this.k;
                        int i4 = jy9Var.d0;
                        if (jy9Var.c0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        bb9.e(uniqueId, m39Var2, jy9Var, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    m39 m39Var3 = this.k;
                    int i5 = jy9Var.d0;
                    if (jy9Var.c0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    bb9.e(uniqueId2, m39Var3, jy9Var, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: j0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d077d, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091a81)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0776, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.V().getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.u);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(false);
            }
            t0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.s);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void m0(jy9 jy9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, jy9Var) == null) {
            String userId = jy9Var.p().getUserId();
            m39 m39Var = this.k;
            String str2 = "";
            if (m39Var == null) {
                str = "";
            } else {
                str = m39Var.l();
            }
            m39 m39Var2 = this.k;
            if (m39Var2 != null) {
                str2 = m39Var2.m();
            }
            int D = jy9Var.D();
            String O = jy9Var.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, D);
            if (jy9Var.p().getAlaInfo() != null) {
                AlaInfoData alaInfo = jy9Var.p().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void I(jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jy9Var) == null) && jy9Var.E == 0 && jy9Var.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", jy9Var.O());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            fb9 fb9Var = this.a;
            if (fb9Var != null) {
                int x1 = fb9Var.Q().x1();
                if (1 != x1 && 2 != x1) {
                    if (3 == x1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (jy9Var.p() != null && jy9Var.p().getAlaInfo() != null && jy9Var.p().getAlaInfo().live_status == 1) {
                m0(jy9Var);
            }
        }
    }

    public final void J(jy9 jy9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, jy9Var, pbCommenFloorItemViewHolder, i2) == null) {
            if (pbCommenFloorItemViewHolder.G != null && jy9Var.p() != null) {
                pbCommenFloorItemViewHolder.G.setTag(R.id.tag_user_id, jy9Var.p().getUserId());
                fb9 fb9Var = this.a;
                if (fb9Var != null && fb9Var.V() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.V().c.c);
                }
                ArrayList<IconData> iconInfo = jy9Var.p().getIconInfo();
                int g2 = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.G.g(iconInfo, i2, g2, g2, vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (jy9Var.c0().booleanValue() && !jy9Var.M()) {
                pbCommenFloorItemViewHolder.i.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    public final void K(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m2 = ((((vi.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m2 = (m2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (m2 - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m2 /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((m2 - i3) * this.i));
            tbRichTextView.getLayoutStrategy().q((int) (m2 * 1.618f * this.i));
        }
    }

    public final void M(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.f1147T.setText(R.string.obfuscated_res_0x7f0f06d6);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.f1147T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.f1147T.setText(R.string.obfuscated_res_0x7f0f046e);
        }
    }

    public final void N(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, jy9Var}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(jy9Var.e0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.I.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z3) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = vi.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                }
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X003));
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                if (layoutParams != null) {
                    layoutParams.topMargin = vi.g(this.mContext, R.dimen.tbds14);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                }
            }
            if (pbCommenFloorItemViewHolder.r0.getVisibility() != 0 && pbCommenFloorItemViewHolder.y0.getVisibility() != 0) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().k(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            oca.b(jy9Var, pbCommenFloorItemViewHolder.q, (TextUtils.isEmpty(jy9Var.s()) || !this.h) ? false : false);
        }
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048615, this, pbCommenFloorItemViewHolder, i2, jy9Var) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.p);
            if (this.a.V() != null && this.a.V().getPageContext() != null && this.a.V().getPageContext().getOrignalPage() != null) {
                b99 b99Var = this.a.V().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(b99Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(b99Var.b);
                pbCommenFloorItemViewHolder.s0.setOnClickListener(b99Var.d);
                pbCommenFloorItemViewHolder.r0.setOnClickListener(b99Var.d);
                pbCommenFloorItemViewHolder.E.setOnClickListener(b99Var.b);
                pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(b99Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.m);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(b99Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.m);
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.M.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.h0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.l0.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.D.setOnClickListener(new a(this, jy9Var));
                pbCommenFloorItemViewHolder.d0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.e0.setOnClickListener(new b(this, pbCommenFloorItemViewHolder));
                d99 d99Var = this.a.V().d;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.m);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new c(this, pbCommenFloorItemViewHolder, d99Var));
                pbCommenFloorItemViewHolder.o.C = new d(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.C = new e(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.setAfterClickListener(new f(this, i2, pbCommenFloorItemViewHolder));
            }
        }
    }

    public final boolean O(jy9 jy9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jy9Var)) == null) {
            if (this.k.N() != null && this.k.N().getAuthor() != null && this.k.N().getAuthor().getUserId() != null && jy9Var != null && jy9Var.p() != null && jy9Var.p().getUserId() != null) {
                return this.k.N().getAuthor().getUserId().equals(jy9Var.p().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void P(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.N();
        }
    }

    public final void Q(jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, jy9Var) == null) && jy9Var != null) {
            int i2 = 8;
            if (jy9Var.c0) {
                i2 = 2;
            }
            StatisticItem i3 = bb9.i(this.k, jy9Var, jy9Var.d0, i2, 6);
            jy9Var.e0 = i3;
            if (!ListUtils.isEmpty(jy9Var.e0())) {
                Iterator<jy9> it = jy9Var.e0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String g0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            Object obj = "1";
            if (sparseArray == null) {
                return "1";
            }
            Object obj2 = sparseArray.get(R.id.pb_track_more_obj_source);
            if (obj2 != null) {
                obj = obj2;
            }
            sparseArray.remove(R.id.pb_track_more_obj_source);
            view2.setTag(sparseArray);
            return obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void i0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        boolean z;
        boolean z2;
        m39 m39Var;
        m39 m39Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            String str = null;
            boolean z3 = true;
            if (jy9Var.D() > 0 && (m39Var2 = this.k) != null && !m39Var2.i0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0b05), Integer.valueOf(jy9Var.D()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (jy9Var.p() != null) {
                str = jy9Var.p().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    xg5 V = jy9Var.V();
                    z3 = (V != null || StringUtils.isNull(V.b()) || (m39Var = this.k) == null || m39Var.i0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(jy9Var.l0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(jy9Var.l0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(jy9Var.l0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        if (jy9Var.b0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(V.b(), 7, "..."));
                        } else {
                            pbCommenFloorItemViewHolder.n.setText(V.b());
                        }
                    } else {
                        pbCommenFloorItemViewHolder.n.setVisibility(8);
                    }
                    TextView textView2 = pbCommenFloorItemViewHolder.f0;
                    textView2.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
                }
            }
            z2 = false;
            xg5 V2 = jy9Var.V();
            if (V2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(jy9Var.l0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.f0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048589, this, pbCommenFloorItemViewHolder, jy9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.m0.setVisibility(8);
            e0(pbCommenFloorItemViewHolder, jy9Var, view2, i2);
            R(pbCommenFloorItemViewHolder, jy9Var);
            V(pbCommenFloorItemViewHolder, jy9Var);
            Y(pbCommenFloorItemViewHolder, jy9Var, view2);
            X(pbCommenFloorItemViewHolder, jy9Var, view2, i2);
            S(pbCommenFloorItemViewHolder, jy9Var);
            b0(pbCommenFloorItemViewHolder, jy9Var);
            W(pbCommenFloorItemViewHolder, jy9Var);
            u0(pbCommenFloorItemViewHolder, jy9Var);
            c0(pbCommenFloorItemViewHolder, jy9Var);
            e59.d(pbCommenFloorItemViewHolder, jy9Var, view2, this.h, this.A);
            a0(pbCommenFloorItemViewHolder, jy9Var);
            T(pbCommenFloorItemViewHolder, jy9Var);
            Z(pbCommenFloorItemViewHolder, jy9Var);
            d0(pbCommenFloorItemViewHolder, jy9Var);
            f0(pbCommenFloorItemViewHolder, jy9Var);
            e59.i(pbCommenFloorItemViewHolder, view2, jy9Var, this.r, true);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null && jy9Var.n() != null) {
            jy9Var.n().threadId = this.a.Q().R1();
            jy9Var.n().objType = 1;
            jy9Var.n().isInPost = true;
            ThreadData threadData = null;
            m39 m39Var = this.k;
            if (m39Var != null && m39Var.N() != null) {
                threadData = this.k.N();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(jy9Var.n());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(jy9Var.n());
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, jy9Var) == null) {
            if (jy9Var != null && jy9Var.p() != null && jy9Var.h0() != null) {
                TbRichText a0 = jy9Var.a0();
                if (a0 != null && StringUtils.isNull(a0.toString()) && StringUtils.isNull(jy9Var.s())) {
                    z = true;
                } else {
                    z = false;
                }
                if (jy9Var.p().getSmallTailThemeData() != null) {
                    str = jy9Var.p().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                qb9.c(jy9Var.h0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, jy9Var.p().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (jy9Var != null && (alaLiveInfoCoreData = jy9Var.f1135T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(jy9Var.f1135T.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(jy9Var.f1135T);
                pbCommenFloorItemViewHolder.M.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbCommenFloorItemViewHolder.M.setVisibility(8);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, jy9Var) == null) {
            if (jy9Var.I() != 2 && jy9Var.I() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                N(false, pbCommenFloorItemViewHolder, jy9Var);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new m(this, pbCommenFloorItemViewHolder, jy9Var));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                M(pbCommenFloorItemViewHolder, jy9Var.y0(), jy9Var.H());
                N(true, pbCommenFloorItemViewHolder, jy9Var);
            }
            l0(pbCommenFloorItemViewHolder, jy9Var);
        }
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && jy9Var != null) {
            AgreeView agreeView = pbCommenFloorItemViewHolder.c0;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbCommenFloorItemViewHolder.c0.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbCommenFloorItemViewHolder.A0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbCommenFloorItemViewHolder.A0.setImageResource(R.drawable.obfuscated_res_0x7f0809fb);
                pbCommenFloorItemViewHolder.A0.setOnClickListener(new l(this, jy9Var));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbCommenFloorItemViewHolder.B0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(jy9Var.p());
            }
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048592, this, pbCommenFloorItemViewHolder, jy9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            if (jy9Var.g0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, jy9Var);
                if (jy9Var.I() == 2) {
                    pbCommenFloorItemViewHolder.x.setVisibility(8);
                } else {
                    pbCommenFloorItemViewHolder.x.setVisibility(0);
                }
                pbCommenFloorItemViewHolder.w.setVisibility(8);
            }
            ImageView imageView = pbCommenFloorItemViewHolder.y;
            if (imageView != null) {
                SparseArray sparseArray2 = (SparseArray) imageView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    pbCommenFloorItemViewHolder.y.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_load_sub_data, jy9Var);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, jy9Var);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            if (!jy9Var.v0() && !jy9Var.u0(false)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = vi.g(this.mContext, R.dimen.tbds0);
                layoutParams2.leftMargin = vi.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = vi.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = vi.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.q == null) {
                    ka9 ka9Var = new ka9(this.mContext);
                    this.q = ka9Var;
                    ka9Var.f(this.e);
                    this.q.h(this.l);
                    this.q.e(this.m);
                    String str = null;
                    m39 m39Var = this.k;
                    if (m39Var != null && m39Var.N() != null && this.k.N().getAuthor() != null) {
                        str = this.k.N().getAuthor().getUserId();
                    }
                    boolean z = true;
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    m39 m39Var2 = this.k;
                    if (m39Var2 != null) {
                        this.q.j(m39Var2.V(), z);
                        this.q.i(this.k.N());
                    }
                }
                this.q.g(jy9Var.O());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.q);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(jy9Var, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.m);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.p);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (jy9Var.P) {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11ed));
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, pbCommenFloorItemViewHolder, jy9Var, view2) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = vi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = vi.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            K(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(jy9Var.s()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setTid(this.k.P());
            pbCommenFloorItemViewHolder.q.setPid(jy9Var.O());
            pbCommenFloorItemViewHolder.q.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbCommenFloorItemViewHolder.q.setText(jy9Var.a0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, jy9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            fb9 fb9Var = this.a;
            if (fb9Var != null && fb9Var.Q() != null && StringHelper.equals(this.a.Q().Z0(), jy9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, jy9Var) == null) && pbCommenFloorItemViewHolder != null && jy9Var != null) {
            String b0 = jy9Var.b0();
            if (!StringUtils.isNull(b0)) {
                pbCommenFloorItemViewHolder.X.N(b0, 10, false);
                pbCommenFloorItemViewHolder.X.setVisibility(0);
                pbCommenFloorItemViewHolder.W.setVisibility(8);
                return;
            }
            pbCommenFloorItemViewHolder.X.setVisibility(8);
        }
    }

    public final boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            m39 m39Var = this.k;
            if (m39Var != null && m39Var.N() != null) {
                return this.k.N().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View k0(int i2, View view2, ViewGroup viewGroup, jy9 jy9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, jy9Var, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) jy9Var, (jy9) pbCommenFloorItemViewHolder);
            t0(pbCommenFloorItemViewHolder);
            o0(pbCommenFloorItemViewHolder, i2, jy9Var);
            G(pbCommenFloorItemViewHolder);
            jy9 jy9Var2 = (jy9) getItem(i2);
            if (jy9Var2 != null) {
                jy9Var2.d0 = i2 + 1;
                I(jy9Var2);
                H(jy9Var2);
                jy9Var2.r1();
                Q(jy9Var2);
                U(pbCommenFloorItemViewHolder, jy9Var2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.i69, com.baidu.tieba.in
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view2, viewGroup, (jy9) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void t0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048624, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            v0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    u79.I(pbCommenFloorItemViewHolder.g);
                } else {
                    o75.d(pbCommenFloorItemViewHolder.g).C(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.C, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbCommenFloorItemViewHolder.s.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s.g(skinType);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080b7f, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080b80, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f1147T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.f1147T.setText(R.string.obfuscated_res_0x7f0f046e);
            } else {
                m39 m39Var = this.k;
                if (m39Var != null && StringUtils.isNull(m39Var.j())) {
                    pbCommenFloorItemViewHolder.f1147T.setText(this.k.j());
                } else {
                    pbCommenFloorItemViewHolder.f1147T.setText(R.string.obfuscated_res_0x7f0f06d6);
                }
            }
            pbCommenFloorItemViewHolder.o.P(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.I, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.m0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, pbCommenFloorItemViewHolder, jy9Var) == null) {
            String str = "#7F66FE";
            if (jy9Var.q0() != null) {
                VirtualImageCustomFigure q0 = jy9Var.q0();
                pbCommenFloorItemViewHolder.s0.setHeadImageViewResource(q0.getFigureUrl());
                pbCommenFloorItemViewHolder.s0.setTid(jy9Var.O());
                pbCommenFloorItemViewHolder.s0.setLocate(x79.c);
                pbCommenFloorItemViewHolder.s0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(q0.getBackGroundType())) {
                    str = q0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.s0.setHeadImageBackgroundColorResource(q0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(q0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.s0.setHeadImageBackgroundResource(q0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.s0.f(jy9Var.p());
                pbCommenFloorItemViewHolder.q0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setVisibility(0);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_id, jy9Var.p().getUserId());
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_name, jy9Var.p().getUserName());
                pbCommenFloorItemViewHolder.f();
                String q = n95.q("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.b;
                if (pbFragment != null && pbFragment.V() != null && this.b.V().getIntent() != null && this.b.V().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && !this.B && n95.m().n(q, 0) == 3 && !s99.c(this.k)) {
                    this.B = true;
                    pbCommenFloorItemViewHolder.z0.setVisibility(0);
                    pbCommenFloorItemViewHolder.z0.playAnimation();
                    wg.a().postDelayed(new k(this, pbCommenFloorItemViewHolder), 4000L);
                }
            } else {
                pbCommenFloorItemViewHolder.t0.setVisibility(8);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_id, null);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.q0.setVisibility(0);
                pbCommenFloorItemViewHolder.z0.setVisibility(8);
                pbCommenFloorItemViewHolder.z0.pauseAnimation();
            }
            if (jy9Var.r0() != null && !TextUtils.isEmpty(jy9Var.r0().getIcon())) {
                pbCommenFloorItemViewHolder.r0.setData(jy9Var.r0(), false, str);
                pbCommenFloorItemViewHolder.r0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.u0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.u0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.u0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.r0.setTag(R.id.tag_user_id, jy9Var.p().getUserId());
                pbCommenFloorItemViewHolder.r0.setTag(R.id.tag_user_name, jy9Var.p().getUserName());
                this.w = x79.d;
                this.x = pbCommenFloorItemViewHolder.r0.getData();
                pbCommenFloorItemViewHolder.s0.setWithBubble(this.w);
                pbCommenFloorItemViewHolder.s0.setBubbleName(this.x);
                pbCommenFloorItemViewHolder.s0.setVirtualHeadUid(jy9Var.p().getUserId());
            } else {
                if (pbCommenFloorItemViewHolder.u0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.u0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.u0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.r0.setVisibility(8);
                pbCommenFloorItemViewHolder.r0.setTag(R.id.tag_user_name, null);
                pbCommenFloorItemViewHolder.r0.setTag(R.id.tag_user_id, null);
                int i2 = x79.e;
                this.w = i2;
                pbCommenFloorItemViewHolder.s0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.s0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.s0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (jy9Var.q0() != null) {
                x79.a(2, jy9Var.O(), x79.c, this.w, this.x, jy9Var.q());
            }
        }
    }

    public final void w0(TextView textView, jy9 jy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, textView, jy9Var) == null) {
            if (textView == null && jy9Var == null) {
                return;
            }
            textView.setTag(jy9Var);
            m39 m39Var = this.k;
            if (m39Var != null && m39Var.i0()) {
                jy9Var.e1(Boolean.FALSE);
                jy9Var.S0(0);
                textView.setTag(null);
            } else if (jy9Var.p() != null) {
                com.baidu.tbadk.core.data.MetaData p2 = jy9Var.p();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(p2.getUserId())) {
                    jy9Var.e1(Boolean.TRUE);
                    jy9Var.S0(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    o75 d2 = o75.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.w(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (p2.getIs_bawu() == 1 && jy9Var.w0()) {
                    o75 d3 = o75.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    jy9Var.e1(Boolean.TRUE);
                    jy9Var.S0(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (p2.getIs_bawu() == 1 && "manager".equals(p2.getBawu_type())) {
                    o75 d4 = o75.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    jy9Var.e1(Boolean.TRUE);
                    jy9Var.S0(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (p2.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(p2.getBawu_type())) {
                    o75 d5 = o75.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    jy9Var.e1(Boolean.TRUE);
                    jy9Var.S0(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (p2.getIs_bawu() == 1 && "pri_content_assist".equals(p2.getBawu_type())) {
                    o75 d6 = o75.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    jy9Var.e1(Boolean.TRUE);
                    jy9Var.S0(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (p2.getIs_bawu() == 1 && "pri_manage_assist".equals(p2.getBawu_type())) {
                    o75 d7 = o75.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    jy9Var.e1(Boolean.TRUE);
                    jy9Var.S0(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    jy9Var.e1(Boolean.FALSE);
                    jy9Var.S0(0);
                }
            } else {
                jy9Var.e1(Boolean.FALSE);
                jy9Var.S0(0);
            }
        }
    }
}
