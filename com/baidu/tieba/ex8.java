package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.cu8;
import com.baidu.tieba.jg6;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
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
/* loaded from: classes4.dex */
public class ex8 extends pv8<sl9, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public cu8 A;
    public int g;
    public TbRichTextView.u h;
    public boolean i;
    public float j;
    public String k;
    public zs8 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.a0 o;
    public cu8 p;
    public View.OnLongClickListener q;
    public dz8 r;
    public int s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public boolean x;
    public xf<ConstrainImageLayout> y;
    public xf<TbImageView> z;

    /* JADX WARN: Removed duplicated region for block: B:242:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06eb  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0765  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x07a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048596, this, pbCommenFloorItemViewHolder, sl9Var, view2, i2) == null) || pbCommenFloorItemViewHolder == null || sl9Var == null) {
            return;
        }
        if (sl9Var.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.e.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.e.setVisibility(8);
        }
        ThreadData threadData = null;
        pbCommenFloorItemViewHolder.p.setTag(null);
        pbCommenFloorItemViewHolder.p.setUserId(null);
        pbCommenFloorItemViewHolder.g.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.E.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.q.setIsHost(false);
        if (sl9Var.q() != null) {
            String str = this.k;
            if (str != null && !"0".equals(str) && this.k.equals(sl9Var.q().getUserId())) {
                pbCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = sl9Var.q().getIconInfo();
            ArrayList<IconData> tShowInfoNew = sl9Var.q().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, sl9Var.q().getUserId());
                yz8 yz8Var = this.a;
                if (yz8Var != null && yz8Var.Q() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.a.Q().c.c);
                }
                int g2 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int g3 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.G;
                i3 = R.id.tag_user_id;
                userIconBox2.g(iconInfo, 2, g2, g2, g3);
            } else {
                i3 = R.id.tag_user_id;
            }
            if (pbCommenFloorItemViewHolder.F != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.F.setTag(tShowInfoNew.get(0).getUrl());
                }
                yz8 yz8Var2 = this.a;
                if (yz8Var2 != null && yz8Var2.Q() != null) {
                    pbCommenFloorItemViewHolder.F.setOnClickListener(this.a.Q().c.e);
                }
                int g4 = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.F.h(tShowInfoNew, 3, g4, g4, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !sl9Var.q().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        ww8.D(pbCommenFloorItemViewHolder.g);
                    } else {
                        q25.d(pbCommenFloorItemViewHolder.g).C(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = sl9Var.q().getAvater();
            int i4 = sl9Var.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.g.setTag(i3, sl9Var.q().getUserId());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, sl9Var.q().getUserName());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, sl9Var.q().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, uz8.i(this.l, sl9Var, sl9Var.d0, i4, 2));
            String name_show = sl9Var.q().getName_show();
            String userName = sl9Var.q().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.g.setText(bs8.b(this.mContext, pbCommenFloorItemViewHolder.g.getText().toString()));
                pbCommenFloorItemViewHolder.g.setGravity(16);
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, bs8.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (sl9Var.q().getPendantData() != null && !StringUtils.isNull(sl9Var.q().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.E.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.E.i(sl9Var.q());
                pbCommenFloorItemViewHolder.p.setVisibility(8);
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.getHeadView().N(avater, 28, false);
                pbCommenFloorItemViewHolder.E.getHeadView().setUserId(sl9Var.q().getUserId());
                pbCommenFloorItemViewHolder.E.getHeadView().setUserName(sl9Var.q().getUserName());
                zs8 zs8Var = this.l;
                pbCommenFloorItemViewHolder.E.getHeadView().setFid(zs8Var != null ? zs8Var.l() : "");
                zs8 zs8Var2 = this.l;
                pbCommenFloorItemViewHolder.E.getHeadView().setFName(zs8Var2 != null ? zs8Var2.m() : "");
                pbCommenFloorItemViewHolder.E.getHeadView().setFloor(sl9Var.E());
                pbCommenFloorItemViewHolder.E.getHeadView().setTid(sl9Var.O());
                pbCommenFloorItemViewHolder.E.getHeadView().setTag(R.id.tag_statistic_item, uz8.i(this.l, sl9Var, sl9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.E.n(sl9Var.q().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.p, sl9Var.q(), 4);
                pbCommenFloorItemViewHolder.p.setUserId(sl9Var.q().getUserId());
                zs8 zs8Var3 = this.l;
                pbCommenFloorItemViewHolder.p.setFid(zs8Var3 != null ? zs8Var3.l() : "");
                zs8 zs8Var4 = this.l;
                pbCommenFloorItemViewHolder.p.setFName(zs8Var4 != null ? zs8Var4.m() : "");
                pbCommenFloorItemViewHolder.p.setFloor(sl9Var.E());
                pbCommenFloorItemViewHolder.p.setTid(sl9Var.O());
                pbCommenFloorItemViewHolder.p.setUserName(sl9Var.q().getUserName(), sl9Var.n0());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_virtual_user_url, sl9Var.q().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.p.setTag(R.id.tag_statistic_item, uz8.i(this.l, sl9Var, sl9Var.d0, i4, 2));
                pbCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbCommenFloorItemViewHolder.p.N(avater, 28, false);
                pbCommenFloorItemViewHolder.p.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (sl9Var.q() != null && sl9Var.q().getAlaInfo() != null && sl9Var.q().getAlaUserData() != null && sl9Var.q().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbCommenFloorItemViewHolder.p.setAlaInfo(sl9Var.q().getAlaInfo());
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(sl9Var.q().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.p.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbCommenFloorItemViewHolder.E.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.E.getHeadView().setAlaInfo(null);
            }
            t0(pbCommenFloorItemViewHolder.i, sl9Var);
        }
        yz8 yz8Var3 = this.a;
        int level_id = (yz8Var3 == null || yz8Var3.Q() == null || !this.a.Q().y0() || sl9Var.q() == null) ? 0 : sl9Var.q().getLevel_id();
        zs8 zs8Var5 = this.l;
        if (zs8Var5 != null && zs8Var5.h0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.D, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
        }
        int i5 = 15;
        if (pbCommenFloorItemViewHolder.G.getChildCount() == 1) {
            i5 = 13;
        } else if (pbCommenFloorItemViewHolder.G.getChildCount() > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.F.getChildCount() > 0) {
            i5 -= 2;
        }
        if (sl9Var.w() > 1000) {
            i5 -= 2;
        }
        if (sl9Var.w() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            pbCommenFloorItemViewHolder.G.setVisibility(8);
            if (pbCommenFloorItemViewHolder.G.getChildCount() == 1) {
                i5 += 2;
            } else if (pbCommenFloorItemViewHolder.G.getChildCount() > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.i.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.D.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.D.setVisibility(8);
            }
        }
        String name_show2 = sl9Var.q() != null ? sl9Var.q().getName_show() : "";
        int e2 = jr5.e(name_show2);
        if (sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getSealPrefix())) {
            int i6 = i5 - 2;
            if (e2 > i6) {
                name_show2 = jr5.m(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (e2 > i5) {
            name_show2 = jr5.m(name_show2, i5) + StringHelper.STRING_MORE;
        }
        if (sl9Var.q() != null && !StringUtils.isNull(sl9Var.q().getSealPrefix())) {
            pbCommenFloorItemViewHolder.g.setText(e0(sl9Var.q().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.g.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, sl9Var);
        sparseArray.put(R.id.tag_load_sub_data, sl9Var);
        sparseArray.put(R.id.tag_load_sub_view, view2);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(sl9Var.E()));
        sparseArray.put(R.id.tag_forbid_user_post_id, sl9Var.O());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.o);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.c0);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.y);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.z);
        zs8 zs8Var6 = this.l;
        if (zs8Var6 != null && zs8Var6.M() != null) {
            threadData = this.l.M();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z8 = (sl9Var.q() == null || StringUtils.isNull(sl9Var.q().getVirtualUserUrl())) ? false : true;
        zs8 zs8Var7 = this.l;
        if (zs8Var7 == null || zs8Var7.U() == 0 || g0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.l.U() == 1002 || this.l.U() == 3) ? false : true;
            if (this.l.U() == 3 || this.l.h0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (sl9Var != null && sl9Var.q() != null) {
                String userId = sl9Var.q().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || "0".equals(userId) || userId.length() == 0) {
                    z = false;
                }
            }
        }
        zs8 zs8Var8 = this.l;
        if (zs8Var8 != null && zs8Var8.M() != null && this.l.M().getAuthor() != null && sl9Var.q() != null) {
            String userId2 = this.l.M().getAuthor().getUserId();
            String userId3 = sl9Var.q().getUserId();
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
                if (sl9Var != null && sl9Var.q() != null && UtilHelper.isCurrentAccount(sl9Var.q().getUserId())) {
                    z6 = true;
                    z4 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = sl9Var.E() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.U()));
                    if (sl9Var.q() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, sl9Var.q().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, sl9Var.q().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, sl9Var.q().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (sl9Var.q() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, sl9Var.q().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, sl9Var.q().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, sl9Var.q().getName_show());
                    }
                    if (this.l.M() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.l.M().getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, sl9Var.O());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(sl9Var.u0()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.l.U()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i7));
                    sparseArray.put(R.id.tag_del_post_id, sl9Var.O());
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
        if (sl9Var != null) {
            z6 = true;
            z4 = true;
        }
        if (z8) {
        }
        if (sl9Var.E() != 1) {
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

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ dy8 b;
        public final /* synthetic */ ex8 c;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ sl9 a;
            public final /* synthetic */ j b;

            public a(j jVar, sl9 sl9Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, sl9Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = sl9Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j jVar = this.b;
                    jVar.b.b.a(jVar.c.l, null, this.a, jVar.a.q.getLayoutStrategy());
                }
            }
        }

        public j(ex8 ex8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, dy8 dy8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, pbCommenFloorItemViewHolder, dy8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ex8Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = dy8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            sl9 sl9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof SparseArray)) {
                return;
            }
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if ((sparseArray.get(R.id.tag_load_sub_data) instanceof sl9) && (sl9Var = (sl9) sparseArray.get(R.id.tag_load_sub_data)) != null && this.a.c != null && this.b != null) {
                jg.a().postDelayed(new a(this, sl9Var), 100L);
                String O = this.c.l.O();
                if ((StringUtils.isNull(O) || "0".equals(this.c.l.O())) && this.c.l.M() != null) {
                    O = this.c.l.M().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", O).param("fid", this.c.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", sl9Var.O()).param("obj_source", this.c.f0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ex8 b;

        public a(ex8 ex8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.c0) != null && agreeView.getData() != null) {
                if (view2 == this.a.c0.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String O = this.b.l.O();
                if ((StringUtils.isNull(O) || "0".equals(this.b.l.O())) && this.b.l.M() != null) {
                    O = this.b.l.M().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", O).param("fid", this.b.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.c0.getData().postId).param("obj_source", this.b.f0(this.a.c0)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.l());
                statisticItem.param("tid", this.b.l.O());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.i().O());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.d0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex8 a;

        public b(ex8 ex8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    this.a.p.a(view2);
                    return this.a.p.onSingleTapConfirmed(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements yf<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex8 a;

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

        public c(ex8 ex8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes4.dex */
    public class d implements yf<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex8 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public d(ex8 ex8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex8Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yf
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yf
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
        @Override // com.baidu.tieba.yf
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

    /* loaded from: classes4.dex */
    public class e implements cu8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex8 a;

        @Override // com.baidu.tieba.cu8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public e(ex8 ex8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex8Var;
        }

        @Override // com.baidu.tieba.cu8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.p != null) {
                    if ((view2 instanceof TbListTextView) && this.a.n != null) {
                        this.a.n.onClick(view2);
                        return true;
                    }
                    this.a.p.a(view2);
                    this.a.p.onSingleTapConfirmed(motionEvent);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.cu8.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || (((pbFragment = this.a.b) != null && pbFragment.G5() != null && !this.a.b.G5().J1()) || view2.getId() == R.id.obfuscated_res_0x7f090b07)) {
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
                            this.a.N((RelativeLayout) parent);
                            break;
                        }
                    }
                } else {
                    this.a.N(view2);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ex8 b;

        public f(ex8 ex8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.a.c, R.color.CAM_X0205);
                yz8 yz8Var = this.b.a;
                if (yz8Var != null && yz8Var.P() != null) {
                    this.b.a.P().B0();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ sl9 b;
        public final /* synthetic */ ex8 c;

        public g(ex8 ex8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, pbCommenFloorItemViewHolder, sl9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ex8Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = sl9Var;
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
                this.c.K(this.a, !z, this.b.H());
                this.b.S0(!z);
                this.c.j0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment != null && pbFragment.G5() != null && this.c.b.G5().n1() != null && this.c.b.G5().W0() != null && !z && this.a.getView().getTop() < this.c.b.G5().n1().getMeasuredHeight()) {
                    this.c.b.G5().W0().setSelectionFromTop(ListUtils.getPosition(this.c.b.G5().W0().getData(), this.b) + this.c.b.G5().W0().getHeaderViewsCount(), this.c.b.G5().n1().getMeasuredHeight());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ex8 b;

        public h(ex8 ex8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex8Var;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.mContext == null) {
                return;
            }
            CommonStatisticUtils.staticNameplateOfUserLevel(2, 7, this.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.b.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public i(ex8 ex8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, pbCommenFloorItemViewHolder};
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

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ex8 b;

        public k(ex8 ex8Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex8Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex8Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && this.b.l != null && (pbCommenFloorItemViewHolder = this.a) != null && (agreeView = pbCommenFloorItemViewHolder.o) != null && agreeView.getData() != null) {
                if (view2 == this.a.o.getImgAgree()) {
                    i = 1;
                } else {
                    i = 2;
                }
                String O = this.b.l.O();
                if ((StringUtils.isNull(O) || "0".equals(this.b.l.O())) && this.b.l.M() != null) {
                    O = this.b.l.M().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", O).param("fid", this.b.l.l()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.o.getData().postId).param("obj_source", this.b.f0(this.a.o)).param("obj_type", i));
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                statisticItem.param("fid", this.b.l.l());
                statisticItem.param("tid", this.b.l.O());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("post_id", this.b.l.i().O());
                statisticItem.param("obj_source", 1);
                statisticItem.param("obj_type", 1);
                statisticItem.param("obj_locate", this.b.d0());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex8(yz8 yz8Var, BdUniqueId bdUniqueId) {
        super(yz8Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yz8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((yz8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        this.h = null;
        this.i = true;
        this.j = 1.0f;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.u = true;
        this.w = true;
        this.x = false;
        this.y = new xf<>(new c(this), 6, 0);
        this.z = new xf<>(new d(this), 12, 0);
        this.A = new cu8(new e(this));
        if (yz8Var != null && yz8Var.P() != null) {
            this.v = yz8Var.P().t1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void G(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
            pbCommenFloorItemViewHolder.s.setOnTouchListener(new b(this));
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.i = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.s = i2;
        }
    }

    public void n(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, a0Var) == null) {
            this.o = a0Var;
        }
    }

    public void n0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048613, this, f2) == null) {
            this.j = f2;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.t = z;
        }
    }

    public void p0(cu8 cu8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, cu8Var) == null) {
            this.p = cu8Var;
        }
    }

    public void q0(TbRichTextView.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, uVar) == null) {
            this.h = uVar;
        }
    }

    public void r(zs8 zs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, zs8Var) == null) {
            this.l = zs8Var;
        }
    }

    public final void s0(TextView textView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, textView) != null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (!(tag instanceof sl9)) {
            return;
        }
        t0(textView, (sl9) tag);
    }

    public final void P(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null && (imageView = pbCommenFloorItemViewHolder.H) != null && this.l != null) {
            imageView.setVisibility(8);
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            ImageView imageView = pbCommenFloorItemViewHolder.W;
            if (sl9Var.b0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            pbCommenFloorItemViewHolder.h(sl9Var.S, sl9Var.O(), this.x);
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, pbCommenFloorItemViewHolder, sl9Var) == null) {
            TbRichText a0 = sl9Var.a0();
            a0.isChanged = true;
            pbCommenFloorItemViewHolder.q.setText(a0, true, this.h);
        }
    }

    public final void H(sl9 sl9Var) {
        zs8 zs8Var;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sl9Var) == null) && (zs8Var = this.l) != null) {
            if (zs8Var.v0()) {
                AbsVideoPbFragment absVideoPbFragment = this.c;
                if (absVideoPbFragment != null) {
                    BdUniqueId uniqueId = absVideoPbFragment.getUniqueId();
                    zs8 zs8Var2 = this.l;
                    int i4 = sl9Var.d0;
                    if (sl9Var.c0) {
                        i3 = 2;
                    } else {
                        i3 = 8;
                    }
                    uz8.e(uniqueId, zs8Var2, sl9Var, i4, i3, "common_exp_source_pb_comment");
                    return;
                }
                return;
            }
            PbFragment pbFragment = this.b;
            if (pbFragment != null) {
                BdUniqueId uniqueId2 = pbFragment.getUniqueId();
                zs8 zs8Var3 = this.l;
                int i5 = sl9Var.d0;
                if (sl9Var.c0) {
                    i2 = 2;
                } else {
                    i2 = 8;
                }
                uz8.e(uniqueId2, zs8Var3, sl9Var, i5, i2, "common_exp_source_pb_comment");
            }
        }
    }

    public final void I(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sl9Var) == null) && sl9Var.E == 0 && sl9Var.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", sl9Var.O());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            yz8 yz8Var = this.a;
            if (yz8Var != null) {
                int t1 = yz8Var.P().t1();
                if (1 != t1 && 2 != t1) {
                    if (3 == t1) {
                        statisticItem.param("obj_source", "2");
                    } else {
                        statisticItem.param("obj_source", "0");
                    }
                } else {
                    statisticItem.param("obj_source", "1");
                }
            }
            TiebaStatic.log(statisticItem);
            if (sl9Var.q() != null && sl9Var.q().getAlaInfo() != null && sl9Var.q().getAlaInfo().live_status == 1) {
                k0(sl9Var);
            }
        }
    }

    public final void J(TbRichTextView tbRichTextView, View view2, boolean z, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{tbRichTextView, view2, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && tbRichTextView != null && view2 != null) {
            int m = ((((ii.m(TbadkCoreApplication.getInst(), UtilHelper.isFoldScreen()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight()) - i2;
            if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
                m = (m - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
            }
            if (z) {
                i3 = s(R.dimen.tbds115);
            } else {
                i3 = 0;
            }
            tbRichTextView.getLayoutStrategy().J = (m - i3) - s(R.dimen.tbds122);
            if (UtilHelper.isOppoFoldLargeScreen(TbadkCoreApplication.getInst().getContext())) {
                m /= 2;
            }
            tbRichTextView.getLayoutStrategy().r((int) ((m - i3) * this.j));
            tbRichTextView.getLayoutStrategy().q((int) (m * 1.618f * this.j));
        }
    }

    public final void K(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f062e);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f0424);
        }
    }

    public final void M(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, sl9Var}) == null) && pbCommenFloorItemViewHolder != null && (view2 = pbCommenFloorItemViewHolder.I) != null && pbCommenFloorItemViewHolder.S != null && (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) && (pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            boolean z2 = !ListUtils.isEmpty(sl9Var.e0());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.I.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
            if (z) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(0);
                if (z2) {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                    }
                } else {
                    pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                    if (layoutParams2 != null) {
                        layoutParams2.topMargin = 0;
                    }
                }
                pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
                if (layoutParams != null) {
                    layoutParams.topMargin = ii.g(this.mContext, R.dimen.tbds20);
                    pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().m(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().n(ii.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
            if (layoutParams != null) {
                layoutParams.topMargin = ii.g(this.mContext, R.dimen.tbds14);
                pbCommenFloorItemViewHolder.I.setLayoutParams(layoutParams);
            }
        }
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048591, this, pbCommenFloorItemViewHolder, sl9Var, view2) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-2, -2);
            }
            layoutParams.rightMargin = ii.g(this.mContext, R.dimen.M_W_X007);
            layoutParams.leftMargin = ii.g(this.mContext, R.dimen.tbds148);
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
            if (!this.i) {
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.icon_click);
            } else {
                pbCommenFloorItemViewHolder.q.p0(null);
                pbCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
                pbCommenFloorItemViewHolder.q.getLayoutStrategy().h(R.drawable.transparent_bg);
            }
            pbCommenFloorItemViewHolder.q.getLayoutStrategy().z(R.drawable.pic_video);
            J(pbCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(sl9Var.s()), layoutParams.leftMargin + layoutParams.rightMargin);
            pbCommenFloorItemViewHolder.r.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            pbCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
            pbCommenFloorItemViewHolder.q.setText(sl9Var.a0(), true, this.h);
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.q.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.tag_clip_board, sl9Var);
            sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
            pbCommenFloorItemViewHolder.q.setTag(sparseArray);
            pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            pbCommenFloorItemViewHolder.c.setTag(R.id.tag_from, sparseArray);
            pbCommenFloorItemViewHolder.m0.setTag(sparseArray);
            pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        }
    }

    public final void N(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view2) == null) && view2 != null && (view2.getTag() instanceof PbCommenFloorItemViewHolder) && (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).c0) != null && agreeView.getData() != null) {
            pbCommenFloorItemViewHolder.c0.setAgreeSource(2);
            pbCommenFloorItemViewHolder.c0.N();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.l.l());
            statisticItem.param("tid", this.l.O());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.l.i().O());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", d0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.um
    /* renamed from: h0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0739, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f0919f9)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0732, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.Q().getPageContext(), inflate, this.v);
            pbCommenFloorItemViewHolder.t.setConstrainLayoutPool(this.y);
            pbCommenFloorItemViewHolder.t.setImageViewPool(this.z);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.v;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.w);
                pbCommenFloorItemViewHolder.v.setIsVideoThread(true);
            }
            r0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.u);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public final void k0(sl9 sl9Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, sl9Var) == null) {
            String userId = sl9Var.q().getUserId();
            zs8 zs8Var = this.l;
            String str2 = "";
            if (zs8Var == null) {
                str = "";
            } else {
                str = zs8Var.l();
            }
            zs8 zs8Var2 = this.l;
            if (zs8Var2 != null) {
                str2 = zs8Var2.m();
            }
            int E = sl9Var.E();
            String O = sl9Var.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, E);
            if (sl9Var.q().getAlaInfo() != null) {
                AlaInfoData alaInfo = sl9Var.q().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void O(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sl9Var) == null) && sl9Var != null) {
            int i2 = 8;
            if (sl9Var.c0) {
                i2 = 2;
            }
            StatisticItem i3 = uz8.i(this.l, sl9Var, sl9Var.d0, i2, 6);
            sl9Var.e0 = i3;
            if (!ListUtils.isEmpty(sl9Var.e0())) {
                Iterator<sl9> it = sl9Var.e0().iterator();
                while (it.hasNext()) {
                    it.next().e0 = i3;
                }
            }
        }
    }

    public final String f0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, view2)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        zs8 zs8Var;
        zs8 zs8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            String str = null;
            boolean z3 = true;
            if (sl9Var.E() > 0 && (zs8Var2 = this.l) != null && !zs8Var2.h0()) {
                String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f0a3e), Integer.valueOf(sl9Var.E()));
                pbCommenFloorItemViewHolder.C.setVisibility(0);
                pbCommenFloorItemViewHolder.C.setText(format);
                z = true;
            } else {
                pbCommenFloorItemViewHolder.C.setVisibility(8);
                z = false;
            }
            if (sl9Var.q() != null) {
                str = sl9Var.q().getIpAddress();
                if (!TextUtils.isEmpty(str)) {
                    z2 = true;
                    sb5 V = sl9Var.V();
                    z3 = (V != null || StringUtils.isNull(V.b()) || (zs8Var = this.l) == null || zs8Var.h0()) ? false : false;
                    if (!z) {
                        pbCommenFloorItemViewHolder.l.setVisibility(0);
                        i2 = this.g;
                    } else {
                        pbCommenFloorItemViewHolder.l.setVisibility(8);
                        i2 = 0;
                    }
                    if (z3 && !z2) {
                        pbCommenFloorItemViewHolder.m.setVisibility(8);
                        i3 = 0;
                    } else {
                        pbCommenFloorItemViewHolder.m.setVisibility(0);
                        i3 = this.g;
                    }
                    pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
                    if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(sl9Var.l0()), "yyyy"))) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(sl9Var.l0()));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(sl9Var.l0()));
                    }
                    if (!z2) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        TextView textView = pbCommenFloorItemViewHolder.n;
                        textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + str);
                    } else if (z3) {
                        pbCommenFloorItemViewHolder.n.setVisibility(0);
                        pbCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                        if (sl9Var.b0) {
                            pbCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(V.b(), 7, StringHelper.STRING_MORE));
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
            sb5 V2 = sl9Var.V();
            if (V2 != null) {
            }
            if (!z) {
            }
            if (z3) {
            }
            pbCommenFloorItemViewHolder.m.setVisibility(0);
            i3 = this.g;
            pbCommenFloorItemViewHolder.k.setPadding(i2, 0, i3, 0);
            if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(sl9Var.l0()), "yyyy"))) {
            }
            if (!z2) {
            }
            TextView textView22 = pbCommenFloorItemViewHolder.f0;
            textView22.setText(((Object) pbCommenFloorItemViewHolder.k.getText()) + "  • ");
        }
    }

    public final void t0(TextView textView, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048624, this, textView, sl9Var) == null) {
            if (textView == null && sl9Var == null) {
                return;
            }
            textView.setTag(sl9Var);
            zs8 zs8Var = this.l;
            if (zs8Var != null && zs8Var.h0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (sl9Var.q() != null) {
                MetaData q = sl9Var.q();
                String str = this.k;
                if (str != null && !"0".equals(str) && this.k.equals(q.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    q25 d2 = q25.d(textView);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.w(R.color.CAM_X0302);
                    d2.l(R.color.CAM_X0302);
                } else if (q.getIs_bawu() == 1 && sl9Var.v0()) {
                    q25 d3 = q25.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (q.getIs_bawu() == 1 && "manager".equals(q.getBawu_type())) {
                    q25 d4 = q25.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (q.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(q.getBawu_type())) {
                    q25 d5 = q25.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (q.getIs_bawu() == 1 && "pri_content_assist".equals(q.getBawu_type())) {
                    q25 d6 = q25.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (q.getIs_bawu() == 1 && "pri_manage_assist".equals(q.getBawu_type())) {
                    q25 d7 = q25.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048587, this, pbCommenFloorItemViewHolder, sl9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            pbCommenFloorItemViewHolder.A.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.e0.setVisibility(8);
            pbCommenFloorItemViewHolder.y.setVisibility(8);
            pbCommenFloorItemViewHolder.z.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.m0.setVisibility(8);
            b0(pbCommenFloorItemViewHolder, sl9Var, view2, i2);
            c0(pbCommenFloorItemViewHolder, sl9Var);
            P(pbCommenFloorItemViewHolder, sl9Var);
            T(pbCommenFloorItemViewHolder, sl9Var);
            W(pbCommenFloorItemViewHolder, sl9Var, view2);
            V(pbCommenFloorItemViewHolder, sl9Var, view2, i2);
            Q(pbCommenFloorItemViewHolder, sl9Var);
            Y(pbCommenFloorItemViewHolder, sl9Var);
            U(pbCommenFloorItemViewHolder, sl9Var);
            Z(pbCommenFloorItemViewHolder, sl9Var);
            ou8.d(pbCommenFloorItemViewHolder, sl9Var, view2, this.i, this.A);
            R(pbCommenFloorItemViewHolder, sl9Var);
            X(pbCommenFloorItemViewHolder, sl9Var);
            a0(pbCommenFloorItemViewHolder, sl9Var);
            ou8.i(pbCommenFloorItemViewHolder, view2, sl9Var, this.t, true);
            ou8.q(this.a.Q().getPageContext(), pbCommenFloorItemViewHolder, sl9Var);
        }
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null && sl9Var.n() != null) {
            sl9Var.n().threadId = this.a.P().N1();
            sl9Var.n().objType = 1;
            sl9Var.n().isInPost = true;
            ThreadData threadData = null;
            zs8 zs8Var = this.l;
            if (zs8Var != null && zs8Var.M() != null) {
                threadData = this.l.M();
            }
            if (threadData != null && threadData.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.o.setAgreeAlone(true);
            }
            pbCommenFloorItemViewHolder.o.setThreadData(threadData);
            pbCommenFloorItemViewHolder.o.setData(sl9Var.n());
            pbCommenFloorItemViewHolder.c0.setThreadData(threadData);
            pbCommenFloorItemViewHolder.c0.setData(sl9Var.n());
        }
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.c != null) {
            yz8 yz8Var = this.a;
            if (yz8Var != null && yz8Var.P() != null && StringHelper.equals(this.a.P().V0(), sl9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                return;
            }
            yz8 yz8Var2 = this.a;
            if (yz8Var2 != null && yz8Var2.P() != null && StringHelper.equals(this.a.P().U0(), sl9Var.O())) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0313);
                jg.a().postDelayed(new f(this, pbCommenFloorItemViewHolder), 3000L);
                return;
            }
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.c, R.color.CAM_X0205);
        }
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbCommenFloorItemViewHolder, sl9Var) == null) {
            if (sl9Var != null && sl9Var.q() != null && sl9Var.h0() != null) {
                TbRichText a0 = sl9Var.a0();
                if (a0 != null && StringUtils.isNull(a0.toString()) && StringUtils.isNull(sl9Var.s())) {
                    z = true;
                } else {
                    z = false;
                }
                if (sl9Var.q().getSmallTailThemeData() != null) {
                    str = sl9Var.q().getSmallTailThemeData().getPropsId();
                } else {
                    str = "";
                }
                pbCommenFloorItemViewHolder.J.setTag(R.id.tag_pb_small_tail_theme_id, str);
                pbCommenFloorItemViewHolder.K.setTag(R.id.tag_pb_small_tail_theme_id, str);
                j09.c(sl9Var.h0(), pbCommenFloorItemViewHolder.J, pbCommenFloorItemViewHolder.K, pbCommenFloorItemViewHolder.L, false, false, z, sl9Var.q().getSmallTailThemeData());
                return;
            }
            pbCommenFloorItemViewHolder.J.setVisibility(8);
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && pbCommenFloorItemViewHolder.P != null && pbCommenFloorItemViewHolder.M != null) {
            if (sl9Var != null && (alaLiveInfoCoreData = sl9Var.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
                pbCommenFloorItemViewHolder.P.setText(sl9Var.T.liveTitle);
                pbCommenFloorItemViewHolder.M.setTag(sl9Var.T);
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

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, pbCommenFloorItemViewHolder, sl9Var) == null) {
            if (sl9Var.I() != 2 && sl9Var.I() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                M(false, pbCommenFloorItemViewHolder, sl9Var);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, sl9Var));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                K(pbCommenFloorItemViewHolder, sl9Var.x0(), sl9Var.H());
                M(true, pbCommenFloorItemViewHolder, sl9Var);
            }
            j0(pbCommenFloorItemViewHolder, sl9Var);
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, pbCommenFloorItemViewHolder, sl9Var) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null && TbSingleton.getInstance().isUserGrowthOpen() && sl9Var.q().getUserGrowthData() != null) {
            int a2 = sl9Var.q().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                pbCommenFloorItemViewHolder.j.setImageResource(tw.b(a2));
                pbCommenFloorItemViewHolder.j.setVisibility(0);
                pbCommenFloorItemViewHolder.j.setOnClickListener(new h(this, a2));
                CommonStatisticUtils.staticNameplateOfUserLevel(1, 7, a2);
                return;
            }
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, sl9 sl9Var, View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(1048590, this, pbCommenFloorItemViewHolder, sl9Var, view2, i2) == null) && pbCommenFloorItemViewHolder != null && sl9Var != null) {
            if (sl9Var.g0() > 0) {
                pbCommenFloorItemViewHolder.x.setVisibility(8);
            } else {
                SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.x.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                }
                sparseArray.put(R.id.tag_load_sub_data, sl9Var);
                if (sl9Var.I() == 2) {
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
                sparseArray2.put(R.id.tag_load_sub_data, sl9Var);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.z;
            if (imageView2 != null) {
                SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.z.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, sl9Var);
            }
            pbCommenFloorItemViewHolder.w.setVisibility(8);
            boolean z = true;
            if (!sl9Var.u0() && !sl9Var.t0(true)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams.topMargin = 0;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                layoutParams.bottomMargin = 0;
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.v.setVisibility(8);
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.v.getLayoutParams();
                layoutParams2.topMargin = ii.g(this.mContext, R.dimen.tbds10);
                layoutParams2.leftMargin = ii.g(this.mContext, R.dimen.tbds148);
                layoutParams2.rightMargin = ii.g(this.mContext, R.dimen.M_W_X007);
                layoutParams2.bottomMargin = ii.g(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.v.setLayoutParams(layoutParams2);
                if (this.r == null) {
                    dz8 dz8Var = new dz8(this.mContext);
                    this.r = dz8Var;
                    dz8Var.f(this.e);
                    this.r.h(this.m);
                    this.r.e(this.n);
                    String str = null;
                    zs8 zs8Var = this.l;
                    if (zs8Var != null && zs8Var.M() != null && this.l.M().getAuthor() != null) {
                        str = this.l.M().getAuthor().getUserId();
                    }
                    z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                    zs8 zs8Var2 = this.l;
                    if (zs8Var2 != null) {
                        this.r.j(zs8Var2.U(), z);
                        this.r.i(this.l.M());
                    }
                }
                this.r.g(sl9Var.O());
                pbCommenFloorItemViewHolder.v.setSubPbAdapter(this.r);
                pbCommenFloorItemViewHolder.v.setVisibility(0);
                pbCommenFloorItemViewHolder.v.setData(sl9Var, view2);
                pbCommenFloorItemViewHolder.v.setChildOnClickListener(this.n);
                pbCommenFloorItemViewHolder.v.setChildOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.v.setChildOnTouchListener(this.A);
            }
            if (sl9Var.P) {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(4);
            }
            pbCommenFloorItemViewHolder.x.setVisibility(8);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.u.getLayoutParams();
            layoutParams3.topMargin = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
            layoutParams3.bottomMargin = ii.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
            if (pbCommenFloorItemViewHolder.w.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.g0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10bc));
        }
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.s;
        }
        return invokeV.intValue;
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            zs8 zs8Var = this.l;
            if (zs8Var != null && zs8Var.M() != null) {
                return this.l.M().isBlocked();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder e0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new jg6.a(str, R.drawable.pic_smalldot_title));
                return jg6.h(this.a.Q(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public View i0(int i2, View view2, ViewGroup viewGroup, sl9 sl9Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, sl9Var, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, (ViewGroup) sl9Var, (sl9) pbCommenFloorItemViewHolder);
            r0(pbCommenFloorItemViewHolder);
            m0(pbCommenFloorItemViewHolder);
            G(pbCommenFloorItemViewHolder);
            sl9 sl9Var2 = (sl9) getItem(i2);
            if (sl9Var2 != null) {
                sl9Var2.d0 = i2 + 1;
                I(sl9Var2);
                H(sl9Var2);
                sl9Var2.p1();
                O(sl9Var2);
                S(pbCommenFloorItemViewHolder, sl9Var2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.c.setOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.c.setOnLongClickListener(this.q);
            if (this.a.Q() != null && this.a.Q().getPageContext() != null && this.a.Q().getPageContext().getOrignalPage() != null) {
                by8 by8Var = this.a.Q().c;
                pbCommenFloorItemViewHolder.g.setOnClickListener(by8Var.b);
                pbCommenFloorItemViewHolder.p.setOnClickListener(by8Var.b);
                pbCommenFloorItemViewHolder.E.setOnClickListener(by8Var.b);
                pbCommenFloorItemViewHolder.E.getHeadView().setOnClickListener(by8Var.b);
                pbCommenFloorItemViewHolder.q.setOnLongClickListener(this.q);
                pbCommenFloorItemViewHolder.q.setOnTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.n);
                pbCommenFloorItemViewHolder.q.setOnImageClickListener(this.o);
                pbCommenFloorItemViewHolder.q.setOnImageTouchListener(this.A);
                pbCommenFloorItemViewHolder.q.setOnEmotionClickListener(by8Var.f);
                pbCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.n);
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.K.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.M.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.h0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.l0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.d0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.m0.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.e0.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
                dy8 dy8Var = this.a.Q().d;
                pbCommenFloorItemViewHolder.y.setOnClickListener(this.n);
                pbCommenFloorItemViewHolder.z.setOnClickListener(new j(this, pbCommenFloorItemViewHolder, dy8Var));
                pbCommenFloorItemViewHolder.o.B = new k(this, pbCommenFloorItemViewHolder);
                pbCommenFloorItemViewHolder.c0.B = new a(this, pbCommenFloorItemViewHolder);
            }
        }
    }

    @Override // com.baidu.tieba.pv8, com.baidu.tieba.um
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i2, view2, viewGroup, (sl9) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048622, this, pbCommenFloorItemViewHolder) != null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            s0(pbCommenFloorItemViewHolder.i);
            boolean z = true;
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    ww8.D(pbCommenFloorItemViewHolder.g);
                } else {
                    q25.d(pbCommenFloorItemViewHolder.g).C(R.string.F_X02);
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
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.v, ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.w.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.y, R.drawable.obfuscated_res_0x7f080a07, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.z, R.drawable.obfuscated_res_0x7f080a08, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.v.d();
            pbCommenFloorItemViewHolder.t.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() != 8) {
                z = false;
            }
            if (z) {
                pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f0424);
            } else {
                zs8 zs8Var = this.l;
                if (zs8Var != null && StringUtils.isNull(zs8Var.j())) {
                    pbCommenFloorItemViewHolder.T.setText(this.l.j());
                } else {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f062e);
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
}
