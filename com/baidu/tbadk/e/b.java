package com.baidu.tbadk.e;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class b {
    public static final boolean u(View view) {
        if (view == null) {
            return false;
        }
        return d(view.getContext(), view);
    }

    public static final boolean d(Context context, View view) {
        if (context == null || view == null) {
            return false;
        }
        if (context instanceof BaseActivity) {
            ((BaseActivity) context).getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            ((BaseActivity) context).getLayoutMode().h(view);
            return true;
        } else if (context instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) context).getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            ((BaseFragmentActivity) context).getLayoutMode().h(view);
            return true;
        } else {
            return false;
        }
    }
}
