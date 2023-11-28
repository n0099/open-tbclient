package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(m05 popupDialogView, SparseArray<?> tags, List<i05> list, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String floorPostId, boolean z6, boolean z7, int i) {
        i05 i05Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{popupDialogView, tags, list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), floorPostId, Boolean.valueOf(z6), Boolean.valueOf(z7), Integer.valueOf(i)}) == null) {
            Intrinsics.checkNotNullParameter(popupDialogView, "popupDialogView");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(floorPostId, "floorPostId");
            if (!z6) {
                return;
            }
            i05 i05Var2 = null;
            if (z2 && z4 && z5) {
                SparseArray<Object> g = g(tags, z, z3, z4, z5, floorPostId, z7);
                i05Var2 = new i05(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f055b), popupDialogView);
                i05Var2.d.setTag(g);
            } else if (z4) {
                SparseArray<Object> f = f(tags, z);
                if (i == 1002 && !z) {
                    i05Var = new i05(6, TbadkCoreApplication.getInst().getString(R.string.report_text), popupDialogView);
                } else {
                    i05Var = new i05(6, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f055b), popupDialogView);
                }
                i05Var2 = i05Var;
                i05Var2.d.setTag(f);
            }
            if (i05Var2 != null) {
                list.add(i05Var2);
            }
        }
    }

    public static final void b(m05 popupDialogView, SparseArray<?> tags, List<i05> list, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String floorPostId, boolean z6, boolean z7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{popupDialogView, tags, list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), floorPostId, Boolean.valueOf(z6), Boolean.valueOf(z7)}) == null) {
            Intrinsics.checkNotNullParameter(popupDialogView, "popupDialogView");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(floorPostId, "floorPostId");
            if (!z6) {
                return;
            }
            i05 i05Var = null;
            if (z2) {
                SparseArray<Object> g = g(tags, z, z3, z4, z5, floorPostId, z7);
                i05 i05Var2 = new i05(7, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f032e), popupDialogView);
                i05Var2.d.setTag(g);
                i05Var = i05Var2;
            }
            if (i05Var != null) {
                list.add(i05Var);
            }
        }
    }

    public static final void c(m05 popupDialogView, List<i05> list, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{popupDialogView, list, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            Intrinsics.checkNotNullParameter(popupDialogView, "popupDialogView");
            Intrinsics.checkNotNullParameter(list, "list");
            if (!z4) {
                return;
            }
            i05 i05Var = null;
            if (!z && z2 && z3) {
                i05Var = new i05(13, TbadkApplication.getInst().getString(R.string.multi_delete), popupDialogView);
            }
            if (i05Var != null) {
                list.add(i05Var);
            }
        }
    }

    public static final void d(m05 popupDialogView, boolean z, boolean z2, SparseArray<?> tags, List<i05> list, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{popupDialogView, Boolean.valueOf(z), Boolean.valueOf(z2), tags, list, Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            Intrinsics.checkNotNullParameter(popupDialogView, "popupDialogView");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Intrinsics.checkNotNullParameter(list, "list");
            if (!z3) {
                return;
            }
            i05 i05Var = null;
            if (!z4 && !z && z2) {
                i05Var = new i05(5, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0d4b), popupDialogView);
                i05Var.d.setTag(i(tags));
            }
            if (i05Var != null) {
                list.add(i05Var);
            }
        }
    }

    public static final void e(m05 popupDialogView, boolean z, boolean z2, List<i05> list, boolean z3, String floorPostId, boolean z4, boolean z5, boolean z6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{popupDialogView, Boolean.valueOf(z), Boolean.valueOf(z2), list, Boolean.valueOf(z3), floorPostId, Boolean.valueOf(z4), Boolean.valueOf(z5), Boolean.valueOf(z6)}) == null) {
            Intrinsics.checkNotNullParameter(popupDialogView, "popupDialogView");
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(floorPostId, "floorPostId");
            if (!z4) {
                return;
            }
            i05 i05Var = null;
            if ((z5 || z || !z2) && z6 && !z3) {
                i05Var = new i05(5, TbadkCoreApplication.getInst().getString(R.string.report_text), popupDialogView);
                i05Var.d.setTag(floorPostId);
            }
            if (i05Var != null) {
                list.add(i05Var);
            }
        }
    }

    public static final SparseArray<Object> f(SparseArray<?> sparseArray, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, sparseArray, z)) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.tag_should_manage_visible, Boolean.FALSE);
            sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
            return sparseArray2;
        }
        return (SparseArray) invokeLZ.objValue;
    }

    public static final SparseArray<Object> g(SparseArray<?> sparseArray, boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{sparseArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), str, Boolean.valueOf(z5)})) == null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(R.id.tag_should_manage_visible, Boolean.TRUE);
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray2.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray2.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray2.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray2.put(R.id.tag_forbid_user_post_id, str);
            sparseArray2.put(R.id.tag_mul_del_post_type, sparseArray.get(R.id.tag_mul_del_post_type));
            if (!z5 && z2) {
                sparseArray2.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                sparseArray2.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                sparseArray2.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                sparseArray2.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                sparseArray2.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                sparseArray2.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            } else {
                sparseArray2.put(R.id.tag_user_mute_visible, Boolean.FALSE);
            }
            if (z3) {
                sparseArray2.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                sparseArray2.put(R.id.tag_has_sub_post, sparseArray.get(R.id.tag_has_sub_post));
                sparseArray2.put(R.id.tag_is_self_post, Boolean.valueOf(z4));
            } else {
                sparseArray2.put(R.id.tag_should_delete_visible, Boolean.FALSE);
            }
            return sparseArray2;
        }
        return (SparseArray) invokeCommon.objValue;
    }

    public static final NegativeFeedBackData h(AntiData antiData) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, antiData)) == null) {
            SparseArray<String> sparseArray = new SparseArray<>();
            if (antiData != null && antiData.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = antiData.getDelThreadInfoList();
                int size = delThreadInfoList.size();
                for (int i = 0; i < size; i++) {
                    String str = delThreadInfoList.get(i).text_info;
                    if (str != null && str.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            NegativeFeedBackData negativeFeedBackData = new NegativeFeedBackData();
            negativeFeedBackData.setFeedBackReasonMap(sparseArray);
            return negativeFeedBackData;
        }
        return (NegativeFeedBackData) invokeL.objValue;
    }

    public static final SparseArray<Object> i(SparseArray<?> tags) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, tags)) == null) {
            Intrinsics.checkNotNullParameter(tags, "tags");
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
            sparseArray.put(R.id.tag_is_mem, tags.get(R.id.tag_is_mem));
            sparseArray.put(R.id.tag_user_mute_mute_userid, tags.get(R.id.tag_user_mute_mute_userid));
            sparseArray.put(R.id.tag_user_mute_mute_username, tags.get(R.id.tag_user_mute_mute_username));
            sparseArray.put(R.id.tag_user_mute_mute_nameshow, tags.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray.put(R.id.tag_user_mute_post_id, tags.get(R.id.tag_user_mute_post_id));
            sparseArray.put(R.id.tag_user_mute_thread_id, tags.get(R.id.tag_user_mute_thread_id));
            sparseArray.put(R.id.tag_del_post_is_self, tags.get(R.id.tag_del_post_is_self));
            sparseArray.put(R.id.tag_del_post_type, tags.get(R.id.tag_del_post_type));
            sparseArray.put(R.id.tag_del_post_id, tags.get(R.id.tag_del_post_id));
            sparseArray.put(R.id.tag_manage_user_identity, tags.get(R.id.tag_manage_user_identity));
            return sparseArray;
        }
        return (SparseArray) invokeL.objValue;
    }
}
