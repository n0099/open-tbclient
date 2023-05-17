package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ck9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65536, null, i, shareEntity) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CANCEL);
            int i2 = 6;
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 6) {
                            if (i != 8) {
                                i2 = 0;
                            } else {
                                i2 = 5;
                            }
                        }
                    } else {
                        i2 = 4;
                    }
                } else {
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            if (i2 != 0) {
                statisticItem.param("obj_source", i2);
            }
            if (shareEntity == null) {
                TiebaStatic.log(statisticItem);
                return;
            }
            Bundle stats = shareEntity.getStats();
            if (stats != null) {
                statisticItem.param("tid", stats.getString("tid"));
                statisticItem.param("uid", stats.getString("uid"));
                statisticItem.param("fid", stats.getString("fid"));
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(int i, ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i, shareEntity) == null) {
            if (shareEntity != null && GroupInfoData.isValidGroup(shareEntity.groupData)) {
                k58.c(shareEntity.groupData, null, shareEntity.shareMediaType);
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
            int i2 = 6;
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 6) {
                            if (i != 8) {
                                i2 = 0;
                            } else {
                                i2 = 5;
                            }
                        }
                    } else {
                        i2 = 4;
                    }
                } else {
                    i2 = 2;
                }
            } else {
                i2 = 3;
            }
            if (i2 != 0) {
                statisticItem.param("obj_source", i2);
            }
            if (shareEntity == null) {
                TiebaStatic.log(statisticItem);
                return;
            }
            Bundle stats = shareEntity.getStats();
            if (stats != null) {
                int i3 = stats.getInt("obj_param1");
                if (i3 != 0) {
                    statisticItem.param("obj_param1", i3);
                    if (i3 == 2) {
                        statisticItem.param("fid", stats.getString("fid"));
                    } else if (i3 == 3) {
                        int i4 = stats.getInt("obj_type");
                        if (i4 != 0) {
                            statisticItem.param("obj_type", i4);
                        }
                        statisticItem.param("tid", stats.getString("tid")).param("fid", stats.getString("fid"));
                    }
                }
                String string = stats.getString(TiebaStatic.Params.OBJ_URL);
                if (!qi.isEmpty(string)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_URL, string);
                }
                int i5 = stats.getInt("obj_locate");
                int i6 = stats.getInt("source", 0);
                if (i6 == 10 || i6 == 16 || i6 == 3) {
                    i5 = i6;
                }
                statisticItem.param("obj_locate", i5);
                if (i6 == 15) {
                    return;
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
