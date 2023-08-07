package com.baidu.tieba;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@JvmName(name = "ItemTabLogUtil")
/* loaded from: classes5.dex */
public final class fa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i, i2)) == null) {
            if (i != 1) {
                return i != 2 ? -1 : 2;
            } else if (i2 != 1) {
                return i2 != 2 ? -1 : 3;
            } else {
                return 4;
            }
        }
        return invokeII.intValue;
    }

    public static final int b(String name) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, name)) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (Intrinsics.areEqual(ItemCardHelper.a, name)) {
                return 1;
            }
            if (Intrinsics.areEqual(ItemCardHelper.b, name)) {
                return 2;
            }
            return 9;
        }
        return invokeL.intValue;
    }

    public static final void c(ea5 itemLogData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, itemLogData) == null) {
            Intrinsics.checkNotNullParameter(itemLogData, "itemLogData");
            StatisticItem statisticItem = new StatisticItem();
            boolean z = false;
            switch (itemLogData.getType()) {
                case 1:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_ALBUM_CLICK).param("obj_name", itemLogData.c()).param("obj_locate", itemLogData.d()).param("obj_type", itemLogData.h()).param("fid", itemLogData.b()).param("uid", itemLogData.j());
                    break;
                case 2:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_TAG_CLICK).param("obj_name", itemLogData.c()).param("obj_locate", itemLogData.d()).param("fid", itemLogData.b());
                    break;
                case 3:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RECOMMEND_CLICK).param("obj_name", itemLogData.c()).param("obj_locate", itemLogData.d()).param("obj_type", itemLogData.h()).param("fid", itemLogData.b());
                    break;
                case 4:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK).param("obj_name", itemLogData.c()).param("obj_locate", itemLogData.d()).param("obj_type", itemLogData.h()).param("fid", itemLogData.b());
                    break;
                case 5:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_SHOW).param("obj_name", itemLogData.c()).param("obj_source", itemLogData.g()).param("obj_locate", itemLogData.b()).param("obj_type", itemLogData.a());
                    break;
                case 6:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_TAB_RANKING).param("obj_name", itemLogData.c()).param("obj_type", itemLogData.h()).param("fid", itemLogData.b());
                    break;
                case 7:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_EXPORT).param("obj_name", itemLogData.c()).param("obj_type", itemLogData.h()).param("fid", itemLogData.b()).param("uid", itemLogData.j()).param(TiebaStatic.Params.OBJ_PARAM2, itemLogData.a());
                    break;
                case 8:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ORDER_DOWNLOAD_CLICK).param("obj_name", itemLogData.c()).param("obj_type", itemLogData.h()).param("fid", itemLogData.b()).param("uid", itemLogData.j()).param("obj_source", itemLogData.g()).param("obj_param1", itemLogData.a());
                    String e = itemLogData.e();
                    if (!((e == null || e.length() == 0) ? true : true)) {
                        statisticItem.param("obj_locate", itemLogData.e());
                        break;
                    }
                    break;
                case 9:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_RECENT_UPDATE_SHOW).param("fid", itemLogData.b());
                    break;
                case 10:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_RECENT_UPDATE_CLICK).param("fid", itemLogData.b());
                    break;
                case 11:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_HOT_VIDEO_SHOW).param("fid", itemLogData.b()).param("obj_locate", itemLogData.d());
                    break;
                case 12:
                    statisticItem.key(CommonStatisticKey.KEY_ITEM_HOT_VIDEO_CLICK).param("fid", itemLogData.b()).param("obj_locate", itemLogData.d());
                    String i = itemLogData.i();
                    if (!((i == null || i.length() == 0) ? true : true)) {
                        statisticItem.param("post_id", itemLogData.i());
                        break;
                    }
                    break;
                case 13:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_SHOW).param("fid", itemLogData.b()).param("obj_id", itemLogData.c()).param("uid", itemLogData.j());
                    break;
                case 14:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_CLICK).param("fid", itemLogData.b()).param("obj_id", itemLogData.c()).param("uid", itemLogData.j());
                    break;
                case 15:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_SHOW).param("obj_id", itemLogData.c()).param("fid", itemLogData.b()).param("obj_locate", itemLogData.d()).param("uid", itemLogData.j());
                    break;
                case 16:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_GAME_CODE_FLOATING_LAYER_CLICK).param("obj_id", itemLogData.c()).param("fid", itemLogData.b()).param("obj_name", itemLogData.f()).param("obj_type", itemLogData.h());
                    break;
                case 17:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_ACCELERATOR_START_BTN_DESC_SHOW).param("fid", itemLogData.b()).param("uid", itemLogData.j()).param("obj_id", itemLogData.c());
                    break;
                case 18:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_ACCELERATOR_START_BTN_DESC_CLICK).param("fid", itemLogData.b()).param("uid", itemLogData.j()).param("obj_id", itemLogData.c());
                    break;
                case 19:
                    statisticItem.key(CommonStatisticKey.KEY_FRS_ITEM_ACCELERATOR_START_BTN_IMG_CLICK).param("fid", itemLogData.b()).param("uid", itemLogData.j()).param("obj_id", itemLogData.c());
                    break;
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
