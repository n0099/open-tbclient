package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
/* loaded from: classes21.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            bw bcY = absThreadDataSupport.bcY();
            if (bcY.bee()) {
                TiebaStatic.log(l.f(bcY, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bcY, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bcY, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bcY, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bcY, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bcY, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bcY, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bcY() != null) {
            if (absThreadDataSupport.bcY().bee()) {
                s.cfn().e(l.b(absThreadDataSupport.bcY(), str));
            } else {
                s.cfn().e(l.a(absThreadDataSupport.bcY(), str));
            }
        }
    }
}
