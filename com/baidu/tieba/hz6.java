package com.baidu.tieba;

import android.view.View;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FeedTabCardStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2, w05 w05Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, view2, w05Var, str) == null) && w05Var != null && w05Var.getThreadData() != null) {
            ThreadData threadData = w05Var.getThreadData();
            if (threadData.isVideoThreadType()) {
                TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadVideoAreaStatisticLog(threadData, str));
                return;
            }
            int id = view2.getId();
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadPotraitStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadEnterForumStatisticLog(threadData, str));
                    return;
                } else if (id == R.id.thread_info_commont_container) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
                    return;
                } else if (view2 instanceof TbImageView) {
                    TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadBigPictureStatisticLog(threadData, str));
                    return;
                } else {
                    return;
                }
            }
            TiebaStatic.log(FeedTabCardStatisticHelper.clickThreadTitleStatisticLog(threadData, str));
        }
    }

    public static void b(w05 w05Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, w05Var, str) == null) && w05Var != null && w05Var.getThreadData() != null) {
            if (w05Var.getThreadData().isVideoThreadType()) {
                co6.b().a(FeedTabCardStatisticHelper.showVideoThreadStatisticLog(w05Var.getThreadData(), str));
            } else {
                co6.b().a(FeedTabCardStatisticHelper.showPictureTextThreadStatisticLog(w05Var.getThreadData(), str));
            }
        }
    }
}
