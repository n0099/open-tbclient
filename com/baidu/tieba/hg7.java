package com.baidu.tieba;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BdToastData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.message.UserGrowthTaskRequestMessage;
import com.baidu.tbadk.core.util.BdToastHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class hg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(final String str, final boolean z, int i, int i2, final boolean z2) {
        final boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            final Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (i == 3) {
                z3 = true;
            } else {
                z3 = false;
            }
            ah.a().post(new Runnable() { // from class: com.baidu.tieba.uf7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        hg7.b(currentActivity, z, z2, z3, str);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void b(Activity activity, boolean z, boolean z2, boolean z3, String str) {
        int b;
        if (activity != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (z) {
                boolean i = ry4.l().i("key_person_growth_share_switch", false);
                if (z2 && !TbSingleton.getInstance().isUserGrowthTaskCompleted(UserGrowthTaskRequestMessage.SHARE_THREAD) && !i && !z3) {
                    ry4.l().v("key_person_growth_share_switch", true);
                    BdToastData bdToastData = new BdToastData();
                    if (TbadkCoreApplication.getCurrentMemberType() > 0) {
                        bdToastData.setIconType(5);
                    } else {
                        bdToastData.setIconType(4);
                    }
                    ArrayList arrayList = new ArrayList(1);
                    BdToastData.ContentBean contentBean = new BdToastData.ContentBean();
                    contentBean.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.im_share_success_info_ug));
                    arrayList.add(contentBean);
                    String userGrowthWeight = TbSingleton.getInstance().getUserGrowthWeight(UserGrowthTaskRequestMessage.SHARE_THREAD);
                    if (userGrowthWeight != null) {
                        if (TbadkCoreApplication.getCurrentMemberType() > 0 && (b = rm9.b(userGrowthWeight, -1)) >= 0) {
                            userGrowthWeight = (b * 2) + "";
                        }
                        spannableStringBuilder.append((CharSequence) BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX).append((CharSequence) userGrowthWeight);
                        BdToastData.ContentBean contentBean2 = new BdToastData.ContentBean();
                        contentBean2.setHasColor(1);
                        contentBean2.setText(spannableStringBuilder.toString());
                        arrayList.add(contentBean2);
                    }
                    bdToastData.setContent(arrayList);
                    BdToastHelper.toast(bdToastData);
                    MessageManager.getInstance().sendMessage(new UserGrowthTaskRequestMessage(UserGrowthTaskRequestMessage.SHARE_THREAD));
                    return;
                }
                spannableStringBuilder.append((CharSequence) str);
            } else {
                spannableStringBuilder.append((CharSequence) str);
            }
            BdToast.b(TbadkCoreApplication.getInst().getContext(), spannableStringBuilder).i();
        }
    }
}
