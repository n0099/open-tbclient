package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View rootView, int i, ThreadData threadData, String str, z2a z2aVar, int i2, StatisticItem statisticItem, Context context, boolean z, boolean z2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{pbCommenFloorItemViewHolder, mwaVar, rootView, Integer.valueOf(i), threadData, str, z2aVar, Integer.valueOf(i2), statisticItem, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            c(pbCommenFloorItemViewHolder, mwaVar, rootView, threadData, i, str, z2aVar, i2, statisticItem, context, j2a.h(threadData), j2a.j(threadData), z, z2, i3, j2a.t(threadData));
        }
    }

    public static final void b(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar, View rootView, int i, zv9 zv9Var, String str, z2a z2aVar, int i2, StatisticItem statisticItem, Context context, boolean z, boolean z2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{pbCommenFloorItemViewHolder, mwaVar, rootView, Integer.valueOf(i), zv9Var, str, z2aVar, Integer.valueOf(i2), statisticItem, context, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            if (zv9Var != null) {
                threadData = zv9Var.R();
            } else {
                threadData = null;
            }
            ThreadData threadData2 = threadData;
            c(pbCommenFloorItemViewHolder, mwaVar, rootView, threadData2, i, str, z2aVar, i2, statisticItem, context, j2a.i(zv9Var), j2a.k(zv9Var), z, z2, i3, j2a.t(threadData2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x05e6, code lost:
        if (r9.length() != 0) goto L183;
     */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0628  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0651  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x06fa  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0733  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(final PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, final mwa mwaVar, View view2, ThreadData threadData, int i, String str, z2a z2aVar, int i2, StatisticItem statisticItem, final Context context, String str2, String str3, boolean z, boolean z2, int i3, boolean z3) {
        String str4;
        Object obj;
        String str5;
        int i4;
        final String str6;
        int i5;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        String userId;
        boolean z11;
        boolean z12;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{pbCommenFloorItemViewHolder, mwaVar, view2, threadData, Integer.valueOf(i), str, z2aVar, Integer.valueOf(i2), statisticItem, context, str2, str3, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3), Boolean.valueOf(z3)}) == null) && pbCommenFloorItemViewHolder != null && mwaVar != null && threadData != null) {
            if (mwaVar.R) {
                SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.e, R.color.CAM_X0204);
                pbCommenFloorItemViewHolder.e.setVisibility(0);
            } else {
                pbCommenFloorItemViewHolder.e.setVisibility(8);
            }
            pbCommenFloorItemViewHolder.q.setTag(null);
            pbCommenFloorItemViewHolder.q.setUserId(null);
            pbCommenFloorItemViewHolder.q.setTargetScheme("");
            pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
            pbCommenFloorItemViewHolder.F.getHeadView().setTargetScheme("");
            pbCommenFloorItemViewHolder.r.setIsHost(false);
            if (mwaVar.u() == null) {
                str4 = "";
                obj = "0";
            } else {
                if (str != null && !Intrinsics.areEqual("0", str) && Intrinsics.areEqual(str, mwaVar.u().getUserId())) {
                    pbCommenFloorItemViewHolder.r.setIsHost(true);
                }
                ArrayList<IconData> iconInfo = mwaVar.u().getIconInfo();
                ArrayList<IconData> tShowInfoNew = mwaVar.u().getTShowInfoNew();
                str4 = "";
                int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                obj = "0";
                int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                if (iconInfo.size() < 2) {
                    int size = iconInfo.size();
                    if (size > 1) {
                        mwaVar.B1((dimens * size) + (dimens2 * size));
                    } else if (size == 1) {
                        mwaVar.B1(dimens + dimens2);
                    } else {
                        mwaVar.B1(0);
                    }
                } else {
                    mwaVar.B1((dimens * 2) + (dimens2 * 2));
                }
                if (pbCommenFloorItemViewHolder.G != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (z2aVar != null) {
                        pbCommenFloorItemViewHolder.G.setOnClickListener(z2aVar.e);
                    }
                    int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, dimens3, dimens3, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                if (ListUtils.isEmpty(tShowInfoNew) && !mwaVar.u().isBigV()) {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, i2, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
                }
                String avater = mwaVar.u().getAvater();
                String avatarUrl = mwaVar.u().getAvatarUrl();
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_id, mwaVar.u().getUserId());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_target_scheme, mwaVar.u().getTargetScheme());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_user_name, mwaVar.u().getUserName());
                pbCommenFloorItemViewHolder.g.setTag(R.id.tag_virtual_user_url, mwaVar.u().getVirtualUserUrl());
                if (statisticItem != null) {
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_statistic_item, statisticItem);
                }
                String name_show = mwaVar.u().getName_show();
                String userName = mwaVar.u().getUserName();
                if (NickNameActivitySwitch.isOn() && !TextUtils.equals(name_show, userName)) {
                    pbCommenFloorItemViewHolder.h.setText(cu9.b(context, pbCommenFloorItemViewHolder.g.getText().toString()));
                    pbCommenFloorItemViewHolder.g.setGravity(16);
                    pbCommenFloorItemViewHolder.g.setTag(R.id.tag_nick_name_activity, cu9.a());
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
                }
                if (mwaVar.u().getPendantData() != null && !StringUtils.isNull(mwaVar.u().getPendantData().getImgUrl())) {
                    pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds36);
                    pbCommenFloorItemViewHolder.F.i(mwaVar.u());
                    pbCommenFloorItemViewHolder.q.setVisibility(8);
                    pbCommenFloorItemViewHolder.F.setVisibility(0);
                    dy9.a(pbCommenFloorItemViewHolder.F.getHeadView(), avatarUrl, avater, 28);
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserId(mwaVar.u().getUserId());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTargetScheme(mwaVar.u().getTargetScheme());
                    pbCommenFloorItemViewHolder.F.getHeadView().setUserName(mwaVar.u().getUserName());
                    pbCommenFloorItemViewHolder.F.getHeadView().setFid(str2);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFName(str3);
                    pbCommenFloorItemViewHolder.F.getHeadView().setFloor(mwaVar.L());
                    pbCommenFloorItemViewHolder.F.getHeadView().setTid(mwaVar.U());
                    if (statisticItem != null) {
                        pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, statisticItem);
                    }
                    pbCommenFloorItemViewHolder.F.i(mwaVar.u());
                } else {
                    pbCommenFloorItemViewHolder.q.setGodIconWidth(R.dimen.tbds36);
                    UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.q, mwaVar.u(), 4);
                    pbCommenFloorItemViewHolder.q.setUserId(mwaVar.u().getUserId());
                    pbCommenFloorItemViewHolder.q.setTargetScheme(mwaVar.u().getTargetScheme());
                    pbCommenFloorItemViewHolder.q.setFid(str2);
                    pbCommenFloorItemViewHolder.q.setFName(str3);
                    pbCommenFloorItemViewHolder.q.setFloor(mwaVar.L());
                    pbCommenFloorItemViewHolder.q.setTid(mwaVar.U());
                    pbCommenFloorItemViewHolder.q.setUserName(mwaVar.u().getUserName(), mwaVar.u0());
                    pbCommenFloorItemViewHolder.q.setTag(R.id.tag_virtual_user_url, mwaVar.u().getVirtualUserUrl());
                    if (statisticItem != null) {
                        pbCommenFloorItemViewHolder.q.setTag(R.id.tag_statistic_item, statisticItem);
                    }
                    pbCommenFloorItemViewHolder.q.setImageDrawable(null);
                    dy9.a(pbCommenFloorItemViewHolder.q, avatarUrl, avater, 28);
                    pbCommenFloorItemViewHolder.q.setVisibility(0);
                    pbCommenFloorItemViewHolder.F.setVisibility(8);
                }
                if (mwaVar.u() != null && mwaVar.u().getAlaInfo() != null && mwaVar.u().getAlaUserData() != null && mwaVar.u().getAlaUserData().live_status == 1) {
                    pbCommenFloorItemViewHolder.d(true);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(1);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(mwaVar.u().getAlaInfo());
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(mwaVar.u().getAlaInfo());
                } else {
                    pbCommenFloorItemViewHolder.d(false);
                    pbCommenFloorItemViewHolder.q.setLiveStatus(0);
                    pbCommenFloorItemViewHolder.q.setAlaInfo(null);
                    pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                    pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
                }
                j2a.z(pbCommenFloorItemViewHolder.i, mwaVar, str, z3, pbCommenFloorItemViewHolder.j);
                if (z && TbSingleton.getInstance().isUserGrowthOpen() && mwaVar.u().getUserGrowthData() != null) {
                    final int a = mwaVar.u().getUserGrowthData().a();
                    if (a >= 0 && a < 11) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (z12) {
                        pbCommenFloorItemViewHolder.k.setImageResource(ss.b(a));
                        pbCommenFloorItemViewHolder.k.setVisibility(0);
                        pbCommenFloorItemViewHolder.k.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.f2a
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view3) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view3) == null) {
                                    i2a.d(context, a, view3);
                                }
                            }
                        });
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 4, a);
                    } else {
                        pbCommenFloorItemViewHolder.k.setVisibility(8);
                    }
                }
            }
            if (z2 && mwaVar.u() != null) {
                i4 = mwaVar.u().getLevel_id();
                str5 = mwaVar.u().getLevelName();
            } else {
                str5 = str4;
                i4 = 0;
            }
            if (z3) {
                i4 = 0;
            }
            if (i4 > 0) {
                pbCommenFloorItemViewHolder.E.setVisibility(0);
                pbCommenFloorItemViewHolder.E.setLevel(i4, str5);
            } else {
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
            if (z) {
                if (mwaVar.W() == 1 && threadData.isQuestionThread() && !j2a.b(threadData, mwaVar)) {
                    mwaVar.e1(true);
                    pbCommenFloorItemViewHolder.y0.setVisibility(0);
                    if (!mwaVar.z0()) {
                        Boolean V = mwaVar.V();
                        Intrinsics.checkNotNullExpressionValue(V, "postData.getIsShowAskView()");
                        if (V.booleanValue()) {
                            pbCommenFloorItemViewHolder.z0.setVisibility(0);
                            pbCommenFloorItemViewHolder.d0.setVisibility(8);
                            pbCommenFloorItemViewHolder.e0.setVisibility(8);
                            pbCommenFloorItemViewHolder.z0.postDelayed(new Runnable() { // from class: com.baidu.tieba.h2a
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        i2a.e(PbCommenFloorItemViewHolder.this, mwaVar);
                                    }
                                }
                            }, 3000L);
                        } else {
                            pbCommenFloorItemViewHolder.z0.setVisibility(8);
                            j2a.v(pbCommenFloorItemViewHolder, mwaVar);
                            pbCommenFloorItemViewHolder.e0.setVisibility(0);
                        }
                    }
                } else {
                    mwaVar.e1(false);
                    pbCommenFloorItemViewHolder.y0.setVisibility(8);
                    if (!mwaVar.z0()) {
                        pbCommenFloorItemViewHolder.z0.setVisibility(8);
                        j2a.v(pbCommenFloorItemViewHolder, mwaVar);
                        pbCommenFloorItemViewHolder.e0.setVisibility(0);
                    }
                }
                SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.y0, R.color.CAM_X0204);
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0105, 1);
            }
            j2a.a(mwaVar, pbCommenFloorItemViewHolder, z2aVar, 2);
            if (mwaVar.u() != null && mwaVar.u().getName_show() != null) {
                str6 = mwaVar.u().getName_show();
            } else {
                str6 = str4;
            }
            pbCommenFloorItemViewHolder.f.post(new Runnable() { // from class: com.baidu.tieba.g2a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        i2a.f(PbCommenFloorItemViewHolder.this, str6);
                    }
                }
            });
            if (!StringUtils.isNull(mwaVar.u().getDiplayIntro())) {
                pbCommenFloorItemViewHolder.B0.setVisibility(0);
                pbCommenFloorItemViewHolder.B0.setText(mwaVar.u().getDiplayIntro());
            } else {
                pbCommenFloorItemViewHolder.B0.setVisibility(8);
            }
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_clip_board, mwaVar);
            sparseArray.put(R.id.tag_load_sub_data, mwaVar);
            sparseArray.put(R.id.tag_load_sub_view, view2);
            sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i));
            sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(mwaVar.L()));
            sparseArray.put(R.id.tag_forbid_user_post_id, mwaVar.U());
            sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.p);
            sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.d0);
            sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.z);
            sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.A);
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.valueOf(z3));
            if (mwaVar.u() != null && !StringUtils.isNull(mwaVar.u().getVirtualUserUrl())) {
                i5 = i3;
                z4 = true;
            } else {
                i5 = i3;
                z4 = false;
            }
            if (i5 != 0 && !j2a.p(threadData)) {
                if (i5 != 1002 && i5 != 3) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (i5 != 3 && !z3) {
                    z5 = true;
                    z6 = true;
                } else {
                    z5 = false;
                    z6 = false;
                }
                if (mwaVar.u() != null) {
                    String userId2 = mwaVar.u().getUserId();
                    if (UtilHelper.isCurrentAccount(userId2)) {
                        z11 = false;
                    }
                    if (userId2 != null) {
                        if (!Intrinsics.areEqual(obj, userId2)) {
                        }
                    }
                }
                z7 = z11;
                if (threadData.getAuthor() != null && mwaVar.u() != null) {
                    userId = threadData.getAuthor().getUserId();
                    String userId3 = mwaVar.u().getUserId();
                    if (UtilHelper.isCurrentAccount(userId)) {
                        if (UtilHelper.isCurrentAccount(userId3)) {
                            z8 = false;
                            z5 = true;
                            z9 = true;
                        } else {
                            z8 = true;
                            z5 = true;
                            z9 = false;
                        }
                        z10 = true;
                        if (mwaVar.u() != null && UtilHelper.isCurrentAccount(mwaVar.u().getUserId())) {
                            z5 = true;
                            z9 = true;
                        }
                        if (z4) {
                            z8 = false;
                            z5 = false;
                            z7 = false;
                        }
                        int i6 = 1;
                        if (mwaVar.L() == 1) {
                            i6 = 0;
                        }
                        if (z3) {
                            z8 = false;
                            z7 = false;
                        }
                        if (z7) {
                            sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
                            if (mwaVar.u() != null) {
                                sparseArray.put(R.id.tag_forbid_user_name, mwaVar.u().getUserName());
                                sparseArray.put(R.id.tag_forbid_user_name_show, mwaVar.u().getName_show());
                                sparseArray.put(R.id.tag_forbid_user_portrait, mwaVar.u().getPortrait());
                            }
                        } else {
                            sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                        }
                        if (z8) {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (mwaVar.u() != null) {
                                sparseArray.put(R.id.tag_user_mute_mute_userid, mwaVar.u().getUserId());
                                sparseArray.put(R.id.tag_user_mute_mute_username, mwaVar.u().getUserName());
                                sparseArray.put(R.id.tag_user_mute_mute_nameshow, mwaVar.u().getName_show());
                            }
                            sparseArray.put(R.id.tag_user_mute_thread_id, threadData.getId());
                            sparseArray.put(R.id.tag_user_mute_post_id, mwaVar.U());
                        } else {
                            sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                        }
                        if (z5) {
                            sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                            sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(mwaVar.B0()));
                            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
                            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z9));
                            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                            sparseArray.put(R.id.tag_del_post_id, mwaVar.U());
                        } else {
                            sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        }
                        sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
                        sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
                        pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                        pbCommenFloorItemViewHolder.t.setTag(sparseArray);
                    }
                }
                z8 = false;
                z9 = false;
                z10 = false;
                if (mwaVar.u() != null) {
                    z5 = true;
                    z9 = true;
                }
                if (z4) {
                }
                int i62 = 1;
                if (mwaVar.L() == 1) {
                }
                if (z3) {
                }
                if (z7) {
                }
                if (z8) {
                }
                if (z5) {
                }
                sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
                sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
                pbCommenFloorItemViewHolder.t.setTag(sparseArray);
            }
            z5 = false;
            z6 = false;
            z7 = false;
            if (threadData.getAuthor() != null) {
                userId = threadData.getAuthor().getUserId();
                String userId32 = mwaVar.u().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                }
            }
            z8 = false;
            z9 = false;
            z10 = false;
            if (mwaVar.u() != null) {
            }
            if (z4) {
            }
            int i622 = 1;
            if (mwaVar.L() == 1) {
            }
            if (z3) {
            }
            if (z7) {
            }
            if (z8) {
            }
            if (z5) {
            }
            sparseArray.put(R.id.tag_mul_del_post_type, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_is_self_post, Boolean.valueOf(z10));
            pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            pbCommenFloorItemViewHolder.t.setTag(sparseArray);
        }
    }

    public static final void d(Context context, int i, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65539, null, context, i, view2) != null) || context == null) {
            return;
        }
        CommonStatisticUtils.staticNameplateOfUserLevel(2, 4, i);
        BrowserHelper.startWebActivity(context, (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
    }

    public static final void e(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pbCommenFloorItemViewHolder, mwaVar) == null) {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
            j2a.v(pbCommenFloorItemViewHolder, mwaVar);
            pbCommenFloorItemViewHolder.e0.setVisibility(0);
        }
    }

    public static final void f(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, pbCommenFloorItemViewHolder, str) == null) {
            int measuredWidth = pbCommenFloorItemViewHolder.f.getMeasuredWidth();
            ArrayList arrayList = new ArrayList();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.G;
            Intrinsics.checkNotNullExpressionValue(userIconBox, "holder.mVipIconBox");
            arrayList.add(userIconBox);
            TextView textView = pbCommenFloorItemViewHolder.i;
            Intrinsics.checkNotNullExpressionValue(textView, "holder.mFloorAuthorView");
            arrayList.add(textView);
            TbImageView tbImageView = pbCommenFloorItemViewHolder.j;
            Intrinsics.checkNotNullExpressionValue(tbImageView, "holder.mFloorAuthorImageView");
            arrayList.add(tbImageView);
            TbImageView tbImageView2 = pbCommenFloorItemViewHolder.k;
            if (tbImageView2 != null) {
                Intrinsics.checkNotNullExpressionValue(tbImageView2, "holder.mPbCommonUserGrowthLevel");
                arrayList.add(tbImageView2);
            }
            RelativeLayout relativeLayout = pbCommenFloorItemViewHolder.y0;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "holder.rlAgreeShow");
            arrayList.add(relativeLayout);
            TbLevelView tbLevelView = pbCommenFloorItemViewHolder.E;
            Intrinsics.checkNotNullExpressionValue(tbLevelView, "holder.mForumLevelIcon");
            arrayList.add(tbLevelView);
            TextView textView2 = pbCommenFloorItemViewHolder.g;
            Intrinsics.checkNotNullExpressionValue(textView2, "holder.mUserNameView");
            TbLevelView tbLevelView2 = pbCommenFloorItemViewHolder.E;
            Intrinsics.checkNotNullExpressionValue(tbLevelView2, "holder.mForumLevelIcon");
            zu5.c(measuredWidth, str, textView2, tbLevelView2, arrayList, pbCommenFloorItemViewHolder.H);
            bv5.a(pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.G, pbCommenFloorItemViewHolder.k, pbCommenFloorItemViewHolder.E, pbCommenFloorItemViewHolder.H, 1);
        }
    }
}
