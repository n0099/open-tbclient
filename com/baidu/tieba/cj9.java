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
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
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
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.gg9;
import com.baidu.tieba.gp6;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbTopCommenFloorItemViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class cj9 extends wh9<yca, PbTopCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.t g;
    public boolean h;
    public float i;
    public String j;
    public ze9 k;
    public View.OnClickListener l;
    public TbRichTextView.z m;
    public gg9 n;
    public View.OnLongClickListener o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public String t;
    public ng<ConstrainImageLayout> u;
    public ng<TbImageView> v;
    public gg9 w;

    /* JADX WARN: Removed duplicated region for block: B:273:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x07e2  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x07eb  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0837  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x083e  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x08a7  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x08b1  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x08f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048604, this, pbTopCommenFloorItemViewHolder, ycaVar, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || ycaVar == null) {
            return;
        }
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.e, R.color.CAM_X0204);
        pbTopCommenFloorItemViewHolder.e.setVisibility(0);
        pbTopCommenFloorItemViewHolder.q.setTag(null);
        pbTopCommenFloorItemViewHolder.q.setUserId(null);
        pbTopCommenFloorItemViewHolder.C.getHeadView().setUserId(null);
        pbTopCommenFloorItemViewHolder.r.setIsHost(false);
        if (ycaVar.q() != null) {
            String str = this.j;
            if (str != null && !str.equals("0") && this.j.equals(ycaVar.q().getUserId())) {
                pbTopCommenFloorItemViewHolder.r.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = ycaVar.q().getIconInfo();
            ArrayList<IconData> tShowInfoNew = ycaVar.q().getTShowInfoNew();
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    ycaVar.t1((g2 * i3) + (g3 * i3));
                } else if (i3 == 1) {
                    ycaVar.t1(g2 + g3);
                } else {
                    ycaVar.t1(0);
                }
            } else {
                ycaVar.t1((g2 * 2) + (g3 * 2));
                i3 = 2;
            }
            if (pbTopCommenFloorItemViewHolder.D != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbTopCommenFloorItemViewHolder.D.setTag(tShowInfoNew.get(0).getUrl());
                }
                bn9 bn9Var = this.a;
                if (bn9Var != null && bn9Var.X() != null) {
                    pbTopCommenFloorItemViewHolder.D.setOnClickListener(this.a.X().c.e);
                }
                int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbTopCommenFloorItemViewHolder.D.h(tShowInfoNew, 3, g4, g4, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !ycaVar.q().isBigV()) {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0107, 1);
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0301, 1);
            }
            String avater = ycaVar.q().getAvater();
            int i5 = ycaVar.d0 ? 2 : 8;
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.tag_pb_top_replay_more, ycaVar);
            pbTopCommenFloorItemViewHolder.p.setTag(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_user_id, ycaVar.q().getUserId());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_user_name, ycaVar.q().getUserName());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_virtual_user_url, ycaVar.q().getVirtualUserUrl());
            pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_statistic_item, xm9.i(this.k, ycaVar, ycaVar.e0, i5, 2));
            String name_show = ycaVar.q().getName_show();
            String userName = ycaVar.q().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbTopCommenFloorItemViewHolder.i.setText(ae9.b(this.mContext, pbTopCommenFloorItemViewHolder.h.getText().toString()));
                pbTopCommenFloorItemViewHolder.h.setGravity(16);
                pbTopCommenFloorItemViewHolder.h.setTag(R.id.tag_nick_name_activity, ae9.a());
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0312, 1);
            }
            if (ycaVar.q().getPendantData() != null && !StringUtils.isNull(ycaVar.q().getPendantData().getImgUrl())) {
                pbTopCommenFloorItemViewHolder.C.setBigVDimenSize(R.dimen.tbds36);
                pbTopCommenFloorItemViewHolder.C.i(ycaVar.q());
                pbTopCommenFloorItemViewHolder.q.setVisibility(8);
                pbTopCommenFloorItemViewHolder.C.setVisibility(0);
                pbTopCommenFloorItemViewHolder.C.getHeadView().N(avater, 28, false);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setUserId(ycaVar.q().getUserId());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setUserName(ycaVar.q().getUserName());
                ze9 ze9Var = this.k;
                pbTopCommenFloorItemViewHolder.C.getHeadView().setFid(ze9Var != null ? ze9Var.l() : "");
                ze9 ze9Var2 = this.k;
                pbTopCommenFloorItemViewHolder.C.getHeadView().setFName(ze9Var2 != null ? ze9Var2.m() : "");
                pbTopCommenFloorItemViewHolder.C.getHeadView().setFloor(ycaVar.I());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setTid(ycaVar.S());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setTag(R.id.tag_statistic_item, xm9.i(this.k, ycaVar, ycaVar.e0, i5, 2));
                pbTopCommenFloorItemViewHolder.C.setTag(R.id.tag_is_top_question, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.C.i(ycaVar.q());
            } else {
                pbTopCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbTopCommenFloorItemViewHolder.q, ycaVar.q(), 4);
                pbTopCommenFloorItemViewHolder.q.setUserId(ycaVar.q().getUserId());
                ze9 ze9Var3 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFid(ze9Var3 != null ? ze9Var3.l() : "");
                ze9 ze9Var4 = this.k;
                pbTopCommenFloorItemViewHolder.q.setFName(ze9Var4 != null ? ze9Var4.m() : "");
                pbTopCommenFloorItemViewHolder.q.setFloor(ycaVar.I());
                pbTopCommenFloorItemViewHolder.q.setTid(ycaVar.S());
                pbTopCommenFloorItemViewHolder.q.setUserName(ycaVar.q().getUserName(), ycaVar.s0());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, ycaVar.q().getVirtualUserUrl());
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_is_top_question, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, xm9.i(this.k, ycaVar, ycaVar.e0, i5, 2));
                pbTopCommenFloorItemViewHolder.q.setImageDrawable(null);
                pbTopCommenFloorItemViewHolder.q.N(avater, 28, false);
                pbTopCommenFloorItemViewHolder.q.setVisibility(0);
                pbTopCommenFloorItemViewHolder.C.setVisibility(8);
            }
            if (ycaVar.q() != null && ycaVar.q().getAlaInfo() != null && ycaVar.q().getAlaUserData() != null && ycaVar.q().getAlaUserData().live_status == 1) {
                pbTopCommenFloorItemViewHolder.e(true);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(ycaVar.q().getAlaInfo());
                pbTopCommenFloorItemViewHolder.C.getHeadView().setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setAlaInfo(ycaVar.q().getAlaInfo());
            } else {
                pbTopCommenFloorItemViewHolder.e(false);
                pbTopCommenFloorItemViewHolder.q.setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.q.setAlaInfo(null);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setAlaInfo(null);
            }
            B0(pbTopCommenFloorItemViewHolder.j, ycaVar);
            if (TbSingleton.getInstance().isUserGrowthOpen() && ycaVar.q().getUserGrowthData() != null) {
                int a2 = ycaVar.q().getUserGrowthData().a();
                if (a2 >= 0 && a2 <= 10) {
                    pbTopCommenFloorItemViewHolder.k.setImageResource(by.b(a2));
                    pbTopCommenFloorItemViewHolder.k.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.k.setOnClickListener(new j(this, a2));
                    CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a2);
                } else {
                    pbTopCommenFloorItemViewHolder.k.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        bn9 bn9Var2 = this.a;
        int level_id = (bn9Var2 == null || bn9Var2.X() == null || !this.a.X().z0() || ycaVar.q() == null) ? 0 : ycaVar.q().getLevel_id();
        ze9 ze9Var5 = this.k;
        if (ze9Var5 != null && ze9Var5.i0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbTopCommenFloorItemViewHolder.B.setVisibility(0);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.B, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbTopCommenFloorItemViewHolder.B.setVisibility(8);
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
        if (pbTopCommenFloorItemViewHolder.D.getChildCount() > 0) {
            i6 -= 2;
        }
        if (ycaVar.A() > 1000) {
            i6 -= 2;
        }
        if (ycaVar.A() > 10) {
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
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.B.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.B.setVisibility(8);
            }
        }
        int l2 = hj9.l();
        String name_show2 = (ycaVar.q() == null || ycaVar.q().getName_show() == null) ? "" : ycaVar.q().getName_show();
        int e2 = dz5.e(name_show2);
        if (ycaVar.q() != null && !StringUtils.isNull(ycaVar.q().getSealPrefix())) {
            int i7 = l2 - 2;
            if (e2 > i7) {
                name_show2 = dz5.m(name_show2, i7) + "...";
            }
        } else if (e2 > l2) {
            name_show2 = dz5.m(name_show2, l2) + "...";
        }
        if (ycaVar.q() != null && !StringUtils.isNull(ycaVar.q().getSealPrefix())) {
            pbTopCommenFloorItemViewHolder.i.setText(l0(ycaVar.q().getSealPrefix(), name_show2));
        } else {
            pbTopCommenFloorItemViewHolder.i.setText(name_show2);
        }
        if (((yca) getItem(i2)).V() == 1 && this.k.N() != null && this.k.N().isQuestionThread() && !S(ycaVar)) {
            ((yca) getItem(i2)).X0(true);
            pbTopCommenFloorItemViewHolder.j0.setVisibility(0);
            if (((yca) getItem(i2)).U().booleanValue()) {
                pbTopCommenFloorItemViewHolder.k0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.W.setVisibility(8);
                pbTopCommenFloorItemViewHolder.X.setVisibility(8);
                pbTopCommenFloorItemViewHolder.k0.postDelayed(new k(this, pbTopCommenFloorItemViewHolder), 3000L);
            } else {
                pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.W.setVisibility(0);
                pbTopCommenFloorItemViewHolder.X.setVisibility(0);
            }
        } else {
            ((yca) getItem(i2)).X0(false);
            pbTopCommenFloorItemViewHolder.j0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.W.setVisibility(0);
            pbTopCommenFloorItemViewHolder.X.setVisibility(0);
        }
        ImageView imageView = pbTopCommenFloorItemViewHolder.x;
        if (imageView != null) {
            SparseArray sparseArray = (SparseArray) imageView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbTopCommenFloorItemViewHolder.x.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, ycaVar);
        }
        ImageView imageView2 = pbTopCommenFloorItemViewHolder.y;
        if (imageView2 != null) {
            SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbTopCommenFloorItemViewHolder.y.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, ycaVar);
        }
        SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.j0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n0, R.color.CAM_X0105, 1);
        pbTopCommenFloorItemViewHolder.g.post(new l(this, pbTopCommenFloorItemViewHolder, new String[]{name_show2}, ycaVar, 2));
        if (!StringUtils.isNull(ycaVar.q().getDiplayIntro())) {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.l0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.l0.setText(ycaVar.q().getDiplayIntro() + "");
        } else {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.l0.setVisibility(8);
        }
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.tag_clip_board, ycaVar);
        sparseArray3.put(R.id.tag_load_sub_data, ycaVar);
        sparseArray3.put(R.id.tag_load_sub_view, view2);
        sparseArray3.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray3.put(R.id.tag_pb_floor_number, Integer.valueOf(ycaVar.I()));
        sparseArray3.put(R.id.tag_forbid_user_post_id, ycaVar.S());
        sparseArray3.put(R.id.pb_dialog_item_zan_2, pbTopCommenFloorItemViewHolder.W);
        sparseArray3.put(R.id.pb_dialog_item_reply, pbTopCommenFloorItemViewHolder.x);
        sparseArray3.put(R.id.pb_dialog_item_share, pbTopCommenFloorItemViewHolder.y);
        ze9 ze9Var6 = this.k;
        ThreadData N = (ze9Var6 == null || ze9Var6.N() == null) ? null : this.k.N();
        if (N != null && N.isUgcThreadType()) {
            sparseArray3.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray3.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z7 = (ycaVar.q() == null || StringUtils.isNull(ycaVar.q().getVirtualUserUrl())) ? false : true;
        ze9 ze9Var7 = this.k;
        if (ze9Var7 == null || ze9Var7.V() == 0 || n0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.k.V() == 1002 || this.k.V() == 3) ? false : true;
            z2 = (this.k.V() == 3 || this.k.i0()) ? false : true;
            if (ycaVar != null && ycaVar.q() != null) {
                String userId = ycaVar.q().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        ze9 ze9Var8 = this.k;
        if (ze9Var8 != null && ze9Var8.N() != null && this.k.N().getAuthor() != null && ycaVar.q() != null) {
            String userId2 = this.k.N().getAuthor().getUserId();
            String userId3 = ycaVar.q().getUserId();
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
                if (ycaVar != null && ycaVar.q() != null && UtilHelper.isCurrentAccount(ycaVar.q().getUserId())) {
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
                if (ycaVar.I() != 1) {
                    i4 = 1;
                }
                if (!z6) {
                    sparseArray3.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.V()));
                    if (ycaVar.q() != null) {
                        sparseArray3.put(R.id.tag_forbid_user_name, ycaVar.q().getUserName());
                        sparseArray3.put(R.id.tag_forbid_user_name_show, ycaVar.q().getName_show());
                        sparseArray3.put(R.id.tag_forbid_user_portrait, ycaVar.q().getPortrait());
                    }
                } else {
                    sparseArray3.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (ycaVar.q() != null) {
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, ycaVar.q().getUserId());
                        sparseArray3.put(R.id.tag_user_mute_mute_username, ycaVar.q().getUserName());
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, ycaVar.q().getName_show());
                    }
                    if (this.k.N() != null) {
                        sparseArray3.put(R.id.tag_user_mute_thread_id, this.k.N().getId());
                    }
                    sparseArray3.put(R.id.tag_user_mute_post_id, ycaVar.S());
                } else {
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray3.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray3.put(R.id.tag_has_sub_post, Boolean.valueOf(ycaVar.z0()));
                    sparseArray3.put(R.id.tag_manage_user_identity, Integer.valueOf(this.k.V()));
                    sparseArray3.put(R.id.tag_del_post_is_self, Boolean.valueOf(z4));
                    sparseArray3.put(R.id.tag_del_post_type, Integer.valueOf(i4));
                    sparseArray3.put(R.id.tag_del_post_id, ycaVar.S());
                } else {
                    sparseArray3.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                sparseArray3.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
                pbTopCommenFloorItemViewHolder.r.setTag(sparseArray3);
                pbTopCommenFloorItemViewHolder.t.setTag(sparseArray3);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (ycaVar != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (ycaVar.I() != 1) {
        }
        if (!z6) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray3.put(R.id.tag_is_self_post, Boolean.valueOf(z5));
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder b;
        public final /* synthetic */ cj9 c;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.tieba.cj9$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class View$OnClickListenerC0259a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0259a(a aVar) {
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
                        xm9.v("c14886");
                        c cVar = this.a.a;
                        cj9 cj9Var = cVar.c;
                        cj9Var.o0(((yca) cj9Var.getItem(cVar.a)).q());
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
                        c cVar = this.a.a;
                        ((yca) cVar.c.getItem(cVar.a)).K0();
                        c cVar2 = this.a.a;
                        if (((yca) cVar2.c.getItem(cVar2.a)).d0() <= 0) {
                            c cVar3 = this.a.a;
                            ((yca) cVar3.c.getItem(cVar3.a)).d1(Boolean.FALSE);
                            this.a.a.b.k0.setVisibility(8);
                            this.a.a.b.W.setVisibility(0);
                            this.a.a.b.X.setVisibility(0);
                        }
                    }
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.b.W.getAgreeFlag()) {
                    return;
                }
                c cVar = this.a;
                ((yca) cVar.c.getItem(cVar.a)).J0();
                c cVar2 = this.a;
                ((yca) cVar2.c.getItem(cVar2.a)).d1(Boolean.TRUE);
                this.a.b.W.setVisibility(8);
                this.a.b.X.setVisibility(8);
                this.a.b.k0.setVisibility(0);
                this.a.b.k0.setOnClickListener(new View$OnClickListenerC0259a(this));
                this.a.b.k0.postDelayed(new b(this), 5000L);
            }
        }

        public c(cj9 cj9Var, int i, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, Integer.valueOf(i), pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj9Var;
            this.a = i;
            this.b = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !UtilHelper.isCurrentAccount(this.c.k.N().getAuthor().getUserId()) || !this.c.k.N().isQuestionThread() || UtilHelper.isCurrentAccount(((yca) this.c.getItem(this.a)).q().getUserId())) {
                return;
            }
            if (this.b.W.getAgreeFlag()) {
                ((yca) this.c.getItem(this.a)).e1(1);
                this.b.j0.setVisibility(0);
                ((yca) this.c.getItem(this.a)).X0(true);
                this.b.j.setVisibility(8);
                this.b.W.postDelayed(new a(this), 900L);
                return;
            }
            ((yca) this.c.getItem(this.a)).e1(0);
            this.b.k0.setVisibility(8);
            this.b.j0.setVisibility(8);
            this.b.W.setVisibility(0);
            ((yca) this.c.getItem(this.a)).X0(false);
            if (((yca) this.c.getItem(this.a)).g0().booleanValue()) {
                this.b.j.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ qk9 b;
        public final /* synthetic */ cj9 c;

        /* renamed from: com.baidu.tieba.cj9$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0258a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ yca a;
            public final /* synthetic */ a b;

            public RunnableC0258a(a aVar, yca ycaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ycaVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = ycaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.b;
                    aVar.b.b.a(aVar.c.k, null, this.a, aVar.a.r.getLayoutStrategy());
                }
            }
        }

        public a(cj9 cj9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, qk9 qk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, pbTopCommenFloorItemViewHolder, qk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj9Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = qk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            yca ycaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof yca) && (ycaVar = (yca) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                zg.a().postDelayed(new RunnableC0258a(this, ycaVar), 100L);
                String P = this.c.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.c.k.P())) && this.c.k.N() != null) {
                    P = this.c.k.N().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.c.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", ycaVar.S()).param("obj_source", this.c.m0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ cj9 b;

        public b(cj9 cj9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cj9Var;
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.k != null && (pbTopCommenFloorItemViewHolder = this.a) != null && (agreeView = pbTopCommenFloorItemViewHolder.W) != null && agreeView.getData() != null) {
                if (view2 == this.a.W.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String P = this.b.k.P();
                if ((StringUtils.isNull(P) || "0".equals(this.b.k.P())) && this.b.k.N() != null) {
                    P = this.b.k.N().getNid();
                }
                if (this.a.W.getData().hasAgree) {
                    i2 = 3;
                } else {
                    i2 = 4;
                }
                xm9.u(i2);
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.b.k.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.W.getData().postId).param("obj_source", this.b.m0(this.a.W)).param("obj_type", i));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj9 a;

        public d(cj9 cj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj9Var;
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

    /* loaded from: classes5.dex */
    public class e implements og<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj9 a;

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

        public e(cj9 cj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj9Var;
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

    /* loaded from: classes5.dex */
    public class f implements og<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj9 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public f(cj9 cj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj9Var;
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

    /* loaded from: classes5.dex */
    public class g implements gg9.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj9 a;

        @Override // com.baidu.tieba.gg9.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public g(cj9 cj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj9Var;
        }

        @Override // com.baidu.tieba.gg9.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.n != null) {
                    if ((view2 instanceof TbListTextView) && this.a.l != null) {
                        this.a.l.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.M6(true);
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

        @Override // com.baidu.tieba.gg9.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || ((pbFragment = this.a.b) != null && pbFragment.L5() != null && !this.a.b.L5().O1())) {
                    return true;
                }
                if (!(view2 instanceof RelativeLayout)) {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (!(parent instanceof RelativeLayout)) {
                            parent = parent.getParent();
                            i++;
                        } else {
                            this.a.T((RelativeLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.T(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yca a;
        public final /* synthetic */ cj9 b;

        public h(cj9 cj9Var, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cj9Var;
            this.a = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q() != null && this.a.q().getPortrait() != null && !TextUtils.isEmpty(this.a.q().getPortrait())) {
                String str2 = null;
                if (this.a.u0() != null) {
                    str2 = this.a.u0().getFigureUrl();
                    str = this.a.u0().getBackgroundValue();
                } else {
                    str = null;
                }
                p46.a(this.b.a.X().getPageContext(), this.a.q().getPortrait(), str2, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ yca b;
        public final /* synthetic */ cj9 c;

        public i(cj9 cj9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, pbTopCommenFloorItemViewHolder, ycaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cj9Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = ycaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.O.getVisibility() == 8) {
                    z = true;
                } else {
                    z = false;
                }
                this.c.Q(this.a, !z, this.b.L());
                this.b.a1(!z);
                this.c.r0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.L5() != null && this.c.b.L5().o1() != null && this.c.b.L5().X0() != null && !z && this.a.getView().getTop() < this.c.b.L5().o1().getMeasuredHeight()) {
                    this.c.b.L5().X0().setSelectionFromTop(ListUtils.getPosition(this.c.b.L5().X0().getData(), this.b) + this.c.b.L5().X0().getHeaderViewsCount(), this.c.b.L5().o1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ cj9 b;

        public j(cj9 cj9Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cj9Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, this.a);
            nx4.v(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public k(cj9 cj9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, pbTopCommenFloorItemViewHolder};
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
                this.a.k0.setVisibility(8);
                this.a.W.setVisibility(0);
                this.a.X.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ yca c;
        public final /* synthetic */ int d;
        public final /* synthetic */ cj9 e;

        public l(cj9 cj9Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, String[] strArr, yca ycaVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, pbTopCommenFloorItemViewHolder, strArr, ycaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = cj9Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = strArr;
            this.c = ycaVar;
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
                boolean k0 = this.e.k0();
                if (!StringUtils.isNull(this.b[0])) {
                    i = this.a.i.getWidth();
                } else {
                    i = 0;
                }
                if (this.a.D.getVisibility() == 8) {
                    width = 0;
                } else {
                    width = this.a.D.getWidth() + hj9.c + hj9.b;
                }
                if (this.a.k.getVisibility() == 8) {
                    width2 = 0;
                } else {
                    width2 = this.a.k.getWidth() + hj9.b;
                }
                if (this.a.B.getVisibility() == 8) {
                    width3 = 0;
                } else {
                    width3 = this.a.B.getWidth() + hj9.b;
                }
                int q = hj9.q(measuredWidth, width, i, width2, width3, k0);
                if (q < 0 && !StringUtils.isNull(this.b[0])) {
                    this.a.h.setWidth(i + q);
                    z = true;
                } else {
                    this.a.h.setWidth(i);
                    z = false;
                }
                if (this.a.i.getText() == null) {
                    this.a.h.setText(this.b[0]);
                } else {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = this.a;
                    pbTopCommenFloorItemViewHolder.h.setText(pbTopCommenFloorItemViewHolder.i.getText());
                }
                if (z) {
                    cj9 cj9Var = this.e;
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder2 = this.a;
                    cj9Var.w0(pbTopCommenFloorItemViewHolder2.h, pbTopCommenFloorItemViewHolder2.k);
                } else {
                    this.e.x0(this.a.k, false);
                }
                this.e.O(this.c, this.a, q, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ TbImageView c;
        public final /* synthetic */ cj9 d;

        public m(cj9 cj9Var, TextView textView, TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj9Var, textView, tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = cj9Var;
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
                boolean z = true;
                int lineCount = layout.getLineCount() - 1;
                if (layout.getEllipsisCount(lineCount) == 0 || layout.getEllipsisStart(lineCount) < 0) {
                    return;
                }
                String charSequence = this.b.getText().toString();
                String substring = charSequence.substring(0, layout.getEllipsisStart(lineCount));
                this.b.setText(charSequence.substring(0, layout.getEllipsisStart(lineCount)).concat("..."));
                this.a = false;
                TbImageView tbImageView = this.c;
                if (tbImageView != null && tbImageView.getVisibility() == 0) {
                    cj9 cj9Var = this.d;
                    TbImageView tbImageView2 = this.c;
                    if (substring.length() % 2 == 0) {
                        z = false;
                    }
                    cj9Var.x0(tbImageView2, z);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj9(bn9 bn9Var, BdUniqueId bdUniqueId) {
        super(bn9Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bn9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bn9) objArr2[0], (BdUniqueId) objArr2[1]);
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
        this.u = new ng<>(new e(this), 6, 0);
        this.v = new ng<>(new f(this), 12, 0);
        this.w = new gg9(new g(this));
        if (bn9Var != null && bn9Var.Q() != null) {
            this.q = bn9Var.Q().y1();
        }
    }

    public final void V(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) {
            if (!TextUtils.isEmpty(ycaVar.t()) && this.h && !k0()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
                if (!TextUtils.isEmpty(ycaVar.B())) {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.t.k(iw4.a(ycaVar.B()));
                } else {
                    pbTopCommenFloorItemViewHolder.t.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.r.p0(ycaVar.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
                pbTopCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
                pbTopCommenFloorItemViewHolder.r.p0(null);
                pbTopCommenFloorItemViewHolder.t.setVisibility(8);
            }
            pbTopCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
        }
    }

    @Override // com.baidu.tieba.wh9, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view2, viewGroup, (yca) obj, (PbTopCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void W(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null && (imageView = pbTopCommenFloorItemViewHolder.F) != null && this.k != null) {
            imageView.setVisibility(8);
        }
    }

    public final void Y(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null) {
            ImageView imageView = pbTopCommenFloorItemViewHolder.f1153T;
            if (ycaVar.c0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void h0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048603, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null) {
            pbTopCommenFloorItemViewHolder.h(ycaVar.f1185T, ycaVar.S(), this.r);
        }
    }

    public final void r0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) {
            TbRichText e0 = ycaVar.e0();
            e0.isChanged = true;
            pbTopCommenFloorItemViewHolder.r.setText(e0, true, this.g);
        }
    }

    public final void w0(TextView textView, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, textView, tbImageView) == null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new m(this, textView, tbImageView));
        }
    }

    public final void A0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof yca)) {
            return;
        }
        B0(textView, (yca) tag);
    }

    public final void L(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbTopCommenFloorItemViewHolder) == null) {
            pbTopCommenFloorItemViewHolder.r.setTextViewOnTouchListener(this.n);
            pbTopCommenFloorItemViewHolder.r.setTextViewCheckSelection(false);
            pbTopCommenFloorItemViewHolder.t.setOnTouchListener(new d(this));
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

    public void n(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, zVar) == null) {
            this.m = zVar;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.j = str;
        }
    }

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, ze9Var) == null) {
            this.k = ze9Var;
        }
    }

    public void u0(gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, gg9Var) == null) {
            this.n = gg9Var;
        }
    }

    public void v0(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, tVar) == null) {
            this.g = tVar;
        }
    }

    public final void B0(TextView textView, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, ycaVar) == null) {
            if (textView == null && ycaVar == null) {
                return;
            }
            textView.setTag(ycaVar);
            ze9 ze9Var = this.k;
            if (ze9Var != null && ze9Var.i0()) {
                ycaVar.l1(Boolean.FALSE);
                ycaVar.Z0(0);
                textView.setTag(null);
            } else if (ycaVar.q() != null) {
                MetaData q = ycaVar.q();
                String str = this.j;
                if (str != null && !str.equals("0") && this.j.equals(q.getUserId())) {
                    ycaVar.l1(Boolean.TRUE);
                    ycaVar.Z0(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    d85 d2 = d85.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.x(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && ycaVar.B0()) {
                    d85 d3 = d85.d(textView);
                    d3.x(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    ycaVar.l1(Boolean.TRUE);
                    ycaVar.Z0(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    d85 d4 = d85.d(textView);
                    d4.x(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    ycaVar.l1(Boolean.TRUE);
                    ycaVar.Z0(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    d85 d5 = d85.d(textView);
                    d5.x(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    ycaVar.l1(Boolean.TRUE);
                    ycaVar.Z0(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    d85 d6 = d85.d(textView);
                    d6.x(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    ycaVar.l1(Boolean.TRUE);
                    ycaVar.Z0(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    d85 d7 = d85.d(textView);
                    d7.x(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    ycaVar.l1(Boolean.TRUE);
                    ycaVar.Z0(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    ycaVar.l1(Boolean.FALSE);
                    ycaVar.Z0(0);
                }
            } else {
                ycaVar.l1(Boolean.FALSE);
                ycaVar.Z0(0);
            }
        }
    }

    public void z0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) {
            String str = "#7F66FE";
            if (ycaVar.u0() != null) {
                VirtualImageCustomFigure u0 = ycaVar.u0();
                pbTopCommenFloorItemViewHolder.f0.setHeadImageViewResource(u0.getFigureUrl());
                pbTopCommenFloorItemViewHolder.f0.setTid(ycaVar.S());
                pbTopCommenFloorItemViewHolder.f0.setLocate(kj9.c);
                pbTopCommenFloorItemViewHolder.f0.setFrom(5);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(u0.getBackGroundType())) {
                    str = u0.getBackgroundValue();
                    pbTopCommenFloorItemViewHolder.f0.setHeadImageBackgroundColorResource(u0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(u0.getBackGroundType())) {
                    pbTopCommenFloorItemViewHolder.f0.setHeadImageBackgroundResource(u0.getBackgroundValue());
                }
                pbTopCommenFloorItemViewHolder.f0.f(ycaVar.q());
                pbTopCommenFloorItemViewHolder.d0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.g0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_id, ycaVar.q().getUserId());
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_name, ycaVar.q().getUserName());
                if (!gl9.c(this.k)) {
                    pbTopCommenFloorItemViewHolder.g();
                    pbTopCommenFloorItemViewHolder.o0.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.o0.playAnimation();
                }
            } else {
                pbTopCommenFloorItemViewHolder.g0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_id, null);
                pbTopCommenFloorItemViewHolder.f0.setTag(R.id.tag_user_name, null);
                pbTopCommenFloorItemViewHolder.d0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.o0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.o0.pauseAnimation();
            }
            if (ycaVar.v0() != null && !TextUtils.isEmpty(ycaVar.v0().getIcon())) {
                pbTopCommenFloorItemViewHolder.e0.setData(ycaVar.v0(), false, str);
                pbTopCommenFloorItemViewHolder.e0.setVisibility(0);
                if (pbTopCommenFloorItemViewHolder.h0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.h0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbTopCommenFloorItemViewHolder.h0.setLayoutParams(marginLayoutParams);
                }
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_id, ycaVar.q().getUserId());
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_name, ycaVar.q().getUserName());
                this.s = kj9.d;
                this.t = pbTopCommenFloorItemViewHolder.e0.getData();
                pbTopCommenFloorItemViewHolder.f0.setWithBubble(this.s);
                pbTopCommenFloorItemViewHolder.f0.setBubbleName(this.t);
                pbTopCommenFloorItemViewHolder.f0.setVirtualHeadUid(ycaVar.q().getUserId());
            } else {
                if (pbTopCommenFloorItemViewHolder.h0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.h0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbTopCommenFloorItemViewHolder.h0.setLayoutParams(marginLayoutParams2);
                }
                pbTopCommenFloorItemViewHolder.e0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_name, null);
                pbTopCommenFloorItemViewHolder.e0.setTag(R.id.tag_user_id, null);
                int i2 = kj9.e;
                this.s = i2;
                pbTopCommenFloorItemViewHolder.f0.setWithBubble(i2);
            }
            if (pbTopCommenFloorItemViewHolder.f0.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.f0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (pbTopCommenFloorItemViewHolder.g0.getVisibility() == 0) {
                layoutParams.setMargins(0, yi.g(this.mContext, R.dimen.M_H_X005), 0, yi.g(this.mContext, R.dimen.tbds5));
            } else {
                layoutParams.setMargins(0, yi.g(this.mContext, R.dimen.M_H_X005), 0, yi.g(this.mContext, R.dimen.tbds_10));
            }
            pbTopCommenFloorItemViewHolder.i0.setLayoutParams(layoutParams);
            if (ycaVar.u0() != null && ycaVar.q() != null) {
                kj9.a(2, ycaVar.S(), kj9.c, this.s, this.t, ycaVar.q().getUserId());
            }
        }
    }

    public final void M(yca ycaVar) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ycaVar) == null) {
            if (ycaVar != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", ycaVar.S());
                statisticItem.param("pid", ycaVar.S());
                statisticItem.param("tid", ycaVar.o0());
                statisticItem.param("fid", ycaVar.N());
                statisticItem.param("fname", ycaVar.P());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            ze9 ze9Var = this.k;
            if (ze9Var != null) {
                if (ze9Var.w0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                        ze9 ze9Var2 = this.k;
                        int i4 = ycaVar.e0;
                        if (ycaVar.d0) {
                            i3 = 2;
                        } else {
                            i3 = 8;
                        }
                        xm9.e(uniqueId, ze9Var2, ycaVar, i4, i3, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                    ze9 ze9Var3 = this.k;
                    int i5 = ycaVar.e0;
                    if (ycaVar.d0) {
                        i2 = 2;
                    } else {
                        i2 = 8;
                    }
                    xm9.e(uniqueId2, ze9Var3, ycaVar, i5, i2, "common_exp_source_pb_comment");
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: p0 */
    public PbTopCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07a7, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091af9)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d079f, (ViewGroup) null));
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = new PbTopCommenFloorItemViewHolder(this.a.X().getPageContext(), inflate, this.q);
            pbTopCommenFloorItemViewHolder.u.setConstrainLayoutPool(this.u);
            pbTopCommenFloorItemViewHolder.u.setImageViewPool(this.v);
            y0(pbTopCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbTopCommenFloorItemViewHolder.r;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.p);
            }
            return pbTopCommenFloorItemViewHolder;
        }
        return (PbTopCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void s0(yca ycaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, ycaVar) == null) {
            String userId = ycaVar.q().getUserId();
            ze9 ze9Var = this.k;
            String str2 = "";
            if (ze9Var == null) {
                str = "";
            } else {
                str = ze9Var.l();
            }
            ze9 ze9Var2 = this.k;
            if (ze9Var2 != null) {
                str2 = ze9Var2.m();
            }
            int I = ycaVar.I();
            String S = ycaVar.S();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", S);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, I);
            if (ycaVar.q().getAlaInfo() != null) {
                AlaInfoData alaInfo = ycaVar.q().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void N(yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, ycaVar) == null) && ycaVar.E == 0 && ycaVar.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", ycaVar.S());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            bn9 bn9Var = this.a;
            if (bn9Var != null) {
                int y1 = bn9Var.Q().y1();
                if (1 != y1 && 2 != y1) {
                    if (3 == y1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (ycaVar.q() != null && ycaVar.q().getAlaInfo() != null && ycaVar.q().getAlaInfo().live_status == 1) {
                s0(ycaVar);
            }
        }
    }

    public final void O(yca ycaVar, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, ycaVar, pbTopCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > ycaVar.x0() + ycaVar.T()) {
                if (pbTopCommenFloorItemViewHolder.E != null && ycaVar.q() != null) {
                    pbTopCommenFloorItemViewHolder.E.setTag(R.id.tag_user_id, ycaVar.q().getUserId());
                    bn9 bn9Var = this.a;
                    if (bn9Var != null && bn9Var.X() != null) {
                        pbTopCommenFloorItemViewHolder.E.setOnClickListener(this.a.X().c.c);
                    }
                    ArrayList<IconData> iconInfo = ycaVar.q().getIconInfo();
                    int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbTopCommenFloorItemViewHolder.E.g(iconInfo, i3, g2, g2, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (ycaVar.g0().booleanValue() && !ycaVar.R()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
            } else if (i2 > ycaVar.T()) {
                if (ycaVar.g0().booleanValue() && !ycaVar.R()) {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
                pbTopCommenFloorItemViewHolder.E.setVisibility(8);
            } else {
                pbTopCommenFloorItemViewHolder.E.setVisibility(8);
                pbTopCommenFloorItemViewHolder.j.setVisibility(8);
            }
        }
    }

    public final void P(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int l2 = ((((yi.l(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                l2 = (l2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((l2 - i3) * this.i));
            tbRichTextView.getLayoutStrategy().J = (l2 - i3) - s(R.dimen.tbds122);
            tbRichTextView.getLayoutStrategy().q((int) (l2 * 1.618f * this.i));
        }
    }

    public final void Q(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{pbTopCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbTopCommenFloorItemViewHolder.O.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f06e3);
                    return;
                } else {
                    pbTopCommenFloorItemViewHolder.Q.setText(str);
                    return;
                }
            }
            pbTopCommenFloorItemViewHolder.O.setVisibility(0);
            pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f0474);
        }
    }

    public final void R(boolean z, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), pbTopCommenFloorItemViewHolder, ycaVar}) == null) && pbTopCommenFloorItemViewHolder != null && (linearLayout = pbTopCommenFloorItemViewHolder.P) != null && (linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = true;
            boolean z3 = !ListUtils.isEmpty(ycaVar.i0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbTopCommenFloorItemViewHolder.P.getLayoutParams();
            if (z) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().n(0);
                if (z3) {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams != null) {
                        layoutParams.topMargin = yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams != null) {
                        layoutParams.topMargin = 0;
                    }
                }
                pbTopCommenFloorItemViewHolder.P.setLayoutParams(layoutParams);
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().m(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().n(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            }
            if (pbTopCommenFloorItemViewHolder.e0.getVisibility() != 0 && pbTopCommenFloorItemViewHolder.l0.getVisibility() != 0) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().k(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X001));
            } else {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().k(yi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X002));
            }
            gra.b(ycaVar, pbTopCommenFloorItemViewHolder.r, (TextUtils.isEmpty(ycaVar.t()) || !this.h) ? false : false);
        }
    }

    public final void d0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048598, this, pbTopCommenFloorItemViewHolder, ycaVar, view2) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.s.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = yi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = yi.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbTopCommenFloorItemViewHolder.r.setPadding(0, 0, 0, 0);
            if (!this.h) {
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbTopCommenFloorItemViewHolder.r.p0(null);
                pbTopCommenFloorItemViewHolder.r.setBackgroundDrawable(null);
                pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbTopCommenFloorItemViewHolder.r.getLayoutStrategy().z(R.drawable.pic_video);
            P(pbTopCommenFloorItemViewHolder.r, view2, !StringUtils.isNull(ycaVar.t()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbTopCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbTopCommenFloorItemViewHolder.r.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbTopCommenFloorItemViewHolder.r.setIsFromCDN(this.e);
            pbTopCommenFloorItemViewHolder.r.setTid(this.k.P());
            pbTopCommenFloorItemViewHolder.r.setPid(ycaVar.S());
            pbTopCommenFloorItemViewHolder.r.setPosition(TbRichTextView.Position.PB_COMMENT_FLOOR);
            pbTopCommenFloorItemViewHolder.r.setText(ycaVar.e0(), true, this.g);
            SparseArray sparseArray = (SparseArray) pbTopCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, ycaVar);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            sparseArray.put(R.id.tag_is_top_question, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbTopCommenFloorItemViewHolder.X.setTag(sparseArray);
            pbTopCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public final boolean S(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, ycaVar)) == null) {
            if (this.k.N() != null && this.k.N().getAuthor() != null && this.k.N().getAuthor().getUserId() != null && ycaVar != null && ycaVar.q() != null && ycaVar.q().getUserId() != null) {
                return this.k.N().getAuthor().getUserId().equals(ycaVar.q().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void U(yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ycaVar) == null) {
            if (ycaVar != null) {
                int i2 = 8;
                if (ycaVar.d0) {
                    i2 = 2;
                }
                StatisticItem i3 = xm9.i(this.k, ycaVar, ycaVar.e0, i2, 6);
                ycaVar.f0 = i3;
                if (!ListUtils.isEmpty(ycaVar.i0())) {
                    Iterator<yca> it = ycaVar.i0().iterator();
                    while (it.hasNext()) {
                        it.next().f0 = i3;
                    }
                }
            }
            xm9.v("c14887");
        }
    }

    public final void T(View view2) {
        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbTopCommenFloorItemViewHolder) && (agreeView = (pbTopCommenFloorItemViewHolder = (PbTopCommenFloorItemViewHolder) view2.getTag()).W) != null && agreeView.getData() != null) {
            pbTopCommenFloorItemViewHolder.W.setAgreeSource(2);
            pbTopCommenFloorItemViewHolder.W.O();
        }
    }

    public final String m0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, view2)) == null) {
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

    public void o0(com.baidu.tbadk.data.MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, metaData) == null) {
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
    public final void X(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        boolean z;
        ze9 ze9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null) {
            String str = null;
            boolean z2 = true;
            if (ycaVar.q() != null) {
                str = ycaVar.q().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z = true;
                    ci5 Z = ycaVar.Z();
                    z2 = (Z != null || StringUtils.isNull(Z.b()) || (ze9Var = this.k) == null || ze9Var.i0()) ? false : false;
                    pbTopCommenFloorItemViewHolder.m.setVisibility(8);
                    if (z2 && !z) {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(8);
                    } else {
                        pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    }
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTimeShort(ycaVar.p0()));
                    } else {
                        pbTopCommenFloorItemViewHolder.l.setText(StringHelper.getFormatTime(ycaVar.p0()));
                    }
                    if (!z) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        TextView textView = pbTopCommenFloorItemViewHolder.o;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z2) {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                        if (ycaVar.c0) {
                            pbTopCommenFloorItemViewHolder.o.setText(StringHelper.cutStringWithSuffix(Z.b(), 7, "..."));
                        } else {
                            pbTopCommenFloorItemViewHolder.o.setText(Z.b());
                        }
                    } else {
                        pbTopCommenFloorItemViewHolder.o.setVisibility(8);
                    }
                    TextView textView2 = pbTopCommenFloorItemViewHolder.Z;
                    textView2.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
                }
            }
            z = false;
            ci5 Z2 = ycaVar.Z();
            if (Z2 != null) {
            }
            pbTopCommenFloorItemViewHolder.m.setVisibility(8);
            if (z2) {
            }
            pbTopCommenFloorItemViewHolder.n.setVisibility(0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(ycaVar.p0()), "yyyy"))) {
            }
            if (!z) {
            }
            TextView textView22 = pbTopCommenFloorItemViewHolder.Z;
            textView22.setText(((Object) pbTopCommenFloorItemViewHolder.l.getText()) + "  • ");
        }
    }

    public final void t0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048622, this, pbTopCommenFloorItemViewHolder, i2) == null) {
            pbTopCommenFloorItemViewHolder.c.setOnTouchListener(this.w);
            pbTopCommenFloorItemViewHolder.c.setOnLongClickListener(this.o);
            if (this.a.X() != null && this.a.X().getPageContext() != null && this.a.X().getPageContext().getOrignalPage() != null) {
                ok9 ok9Var = this.a.X().c;
                pbTopCommenFloorItemViewHolder.h.setOnClickListener(ok9Var.b);
                pbTopCommenFloorItemViewHolder.q.setOnClickListener(ok9Var.b);
                pbTopCommenFloorItemViewHolder.f0.setOnClickListener(ok9Var.d);
                pbTopCommenFloorItemViewHolder.e0.setOnClickListener(ok9Var.d);
                pbTopCommenFloorItemViewHolder.C.setOnClickListener(ok9Var.b);
                pbTopCommenFloorItemViewHolder.C.getHeadView().setOnClickListener(ok9Var.b);
                pbTopCommenFloorItemViewHolder.r.setOnLongClickListener(this.o);
                pbTopCommenFloorItemViewHolder.r.setOnTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setCommonTextViewOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.r.setOnImageClickListener(this.m);
                pbTopCommenFloorItemViewHolder.r.setOnImageTouchListener(this.w);
                pbTopCommenFloorItemViewHolder.r.setOnEmotionClickListener(ok9Var.f);
                pbTopCommenFloorItemViewHolder.r.setOnVoiceAfterClickListener(this.l);
                pbTopCommenFloorItemViewHolder.G.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.H.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.J.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.p.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.X.setOnClickListener(this.l);
                qk9 qk9Var = this.a.X().d;
                pbTopCommenFloorItemViewHolder.x.setOnClickListener(this.l);
                pbTopCommenFloorItemViewHolder.y.setOnClickListener(new a(this, pbTopCommenFloorItemViewHolder, qk9Var));
                pbTopCommenFloorItemViewHolder.W.D = new b(this, pbTopCommenFloorItemViewHolder);
                pbTopCommenFloorItemViewHolder.W.setAfterClickListener(new c(this, i2, pbTopCommenFloorItemViewHolder));
            }
        }
    }

    public final void Z(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048592, this, pbTopCommenFloorItemViewHolder, ycaVar, view2, i2) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null) {
            pbTopCommenFloorItemViewHolder.v.setVisibility(8);
            pbTopCommenFloorItemViewHolder.V.setVisibility(0);
            pbTopCommenFloorItemViewHolder.Y.setVisibility(8);
            i0(pbTopCommenFloorItemViewHolder, ycaVar, view2, i2);
            W(pbTopCommenFloorItemViewHolder, ycaVar);
            a0(pbTopCommenFloorItemViewHolder, ycaVar);
            d0(pbTopCommenFloorItemViewHolder, ycaVar, view2);
            X(pbTopCommenFloorItemViewHolder, ycaVar);
            f0(pbTopCommenFloorItemViewHolder, ycaVar);
            b0(pbTopCommenFloorItemViewHolder, ycaVar);
            z0(pbTopCommenFloorItemViewHolder, ycaVar);
            g0(pbTopCommenFloorItemViewHolder, ycaVar);
            V(pbTopCommenFloorItemViewHolder, ycaVar);
            Y(pbTopCommenFloorItemViewHolder, ycaVar);
            e0(pbTopCommenFloorItemViewHolder, ycaVar);
            h0(pbTopCommenFloorItemViewHolder, ycaVar);
            j0(pbTopCommenFloorItemViewHolder, ycaVar);
            c0(pbTopCommenFloorItemViewHolder, ycaVar);
        }
    }

    public final void a0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && ycaVar != null && ycaVar.o() != null) {
            ycaVar.o().threadId = this.a.Q().S1();
            ycaVar.o().objType = 1;
            ycaVar.o().isInPost = true;
            ThreadData threadData = null;
            ze9 ze9Var = this.k;
            if (ze9Var != null && ze9Var.N() != null) {
                threadData = this.k.N();
            }
            pbTopCommenFloorItemViewHolder.W.setThreadData(threadData);
            pbTopCommenFloorItemViewHolder.W.setData(ycaVar.o());
        }
    }

    public final void b0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.M != null && pbTopCommenFloorItemViewHolder.J != null) {
            if (ycaVar != null && (alaLiveInfoCoreData = ycaVar.U) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbTopCommenFloorItemViewHolder.M.setText(ycaVar.U.liveTitle);
                pbTopCommenFloorItemViewHolder.J.setTag(ycaVar.U);
                pbTopCommenFloorItemViewHolder.J.setVisibility(0);
                StatisticItem statisticItem = new StatisticItem("c12639");
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            pbTopCommenFloorItemViewHolder.J.setVisibility(8);
        }
    }

    public final void g0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar.M() != 2 && ycaVar.M() != 4) {
                pbTopCommenFloorItemViewHolder.P.setVisibility(8);
                pbTopCommenFloorItemViewHolder.O.setVisibility(0);
                R(false, pbTopCommenFloorItemViewHolder, ycaVar);
            } else {
                pbTopCommenFloorItemViewHolder.P.setOnClickListener(new i(this, pbTopCommenFloorItemViewHolder, ycaVar));
                pbTopCommenFloorItemViewHolder.P.setVisibility(0);
                Q(pbTopCommenFloorItemViewHolder, ycaVar.D0(), ycaVar.L());
                R(true, pbTopCommenFloorItemViewHolder, ycaVar);
            }
            r0(pbTopCommenFloorItemViewHolder, ycaVar);
        }
    }

    public final void j0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && WorldCupEnableSwitch.isOn() && ycaVar != null) {
            AgreeView agreeView = pbTopCommenFloorItemViewHolder.W;
            if (agreeView != null) {
                agreeView.setAgreeAlone(true);
                pbTopCommenFloorItemViewHolder.W.setPadding(0, 0, 0, 0);
            }
            TbImageView tbImageView = pbTopCommenFloorItemViewHolder.p0;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                pbTopCommenFloorItemViewHolder.p0.setImageResource(R.drawable.obfuscated_res_0x7f080a08);
                pbTopCommenFloorItemViewHolder.p0.setOnClickListener(new h(this, ycaVar));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = pbTopCommenFloorItemViewHolder.q0;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(ycaVar.q());
            }
        }
    }

    public final void x0(TbImageView tbImageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048626, this, tbImageView, z) != null) || tbImageView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbImageView.getLayoutParams();
        if (z) {
            layoutParams.setMargins(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds_16), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        } else {
            layoutParams.setMargins(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7), 0, 0);
        }
        tbImageView.setLayoutParams(layoutParams);
    }

    public final void c0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar.k0() != 0) {
                pbTopCommenFloorItemViewHolder.p.setVisibility(0);
                TextView textView = pbTopCommenFloorItemViewHolder.p;
                textView.setText("查看全部" + ycaVar.k0() + "条数据");
                return;
            }
            pbTopCommenFloorItemViewHolder.p.setVisibility(8);
        }
    }

    public final void e0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048600, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) && pbTopCommenFloorItemViewHolder != null && pbTopCommenFloorItemViewHolder.c != null) {
            bn9 bn9Var = this.a;
            if (bn9Var != null && bn9Var.Q() != null && StringHelper.equals(this.a.Q().a1(), ycaVar.S())) {
                SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.c, R.color.CAM_X0313);
            } else {
                SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.c, R.color.CAM_X0205);
            }
        }
    }

    public final SpannableStringBuilder l0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new gp6.a(str, R.drawable.pic_smalldot_title));
                return gp6.h(this.a.X(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void f0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, yca ycaVar) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pbTopCommenFloorItemViewHolder, ycaVar) == null) {
            if (ycaVar != null && ycaVar.l0() != null && ycaVar.q() != null && !k0()) {
                TbRichText e0 = ycaVar.e0();
                if (e0 != null && StringUtils.isNull(e0.toString()) && StringUtils.isNull(ycaVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
                if (ycaVar.q().getSmallTailThemeData() != null) {
                    str = ycaVar.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbTopCommenFloorItemViewHolder.G.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbTopCommenFloorItemViewHolder.H.setTag(R.id.tag_pb_small_tail_theme_id, str);
                mn9.c(ycaVar.l0(), pbTopCommenFloorItemViewHolder.G, pbTopCommenFloorItemViewHolder.H, pbTopCommenFloorItemViewHolder.I, false, true, z, ycaVar.q().getSmallTailThemeData());
                return;
            }
            pbTopCommenFloorItemViewHolder.G.setVisibility(8);
            pbTopCommenFloorItemViewHolder.H.setVisibility(8);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ze9 ze9Var = this.k;
            if (ze9Var != null && ze9Var.N() != null) {
                return this.k.N().isQuestionThread();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            ze9 ze9Var = this.k;
            if (ze9Var != null && ze9Var.N() != null) {
                return this.k.N().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public View q0(int i2, View view2, ViewGroup viewGroup, yca ycaVar, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, ycaVar, pbTopCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) ycaVar, (yca) pbTopCommenFloorItemViewHolder);
            y0(pbTopCommenFloorItemViewHolder);
            t0(pbTopCommenFloorItemViewHolder, i2);
            L(pbTopCommenFloorItemViewHolder);
            yca ycaVar2 = (yca) getItem(i2);
            if (ycaVar2 != null) {
                ycaVar2.e0 = i2 + 1;
                N(ycaVar2);
                M(ycaVar2);
                ycaVar2.y1();
                U(ycaVar2);
                Z(pbTopCommenFloorItemViewHolder, ycaVar2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, pbTopCommenFloorItemViewHolder) != null) || pbTopCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbTopCommenFloorItemViewHolder.a != skinType) {
            A0(pbTopCommenFloorItemViewHolder.j);
            boolean z = true;
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.l, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.A, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.o, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m0, R.color.CAM_X0105, 1);
            pbTopCommenFloorItemViewHolder.r.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (pbTopCommenFloorItemViewHolder.t.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.t.g(skinType);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.Z, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.a0, R.color.CAM_X0107, 1);
            pbTopCommenFloorItemViewHolder.u.b();
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.M, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.K, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.J, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.L, R.color.CAM_X0109);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.N, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.Q, (int) R.color.CAM_X0107);
            if (pbTopCommenFloorItemViewHolder.O.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f0474);
            } else {
                ze9 ze9Var = this.k;
                if (ze9Var != null && StringUtils.isNull(ze9Var.j())) {
                    pbTopCommenFloorItemViewHolder.Q.setText(this.k.j());
                } else {
                    pbTopCommenFloorItemViewHolder.Q.setText(R.string.obfuscated_res_0x7f0f06e3);
                }
            }
            pbTopCommenFloorItemViewHolder.d(skinType);
            WebPManager.setPureDrawable(pbTopCommenFloorItemViewHolder.X, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbTopCommenFloorItemViewHolder.c();
        }
        pbTopCommenFloorItemViewHolder.a = skinType;
    }
}
