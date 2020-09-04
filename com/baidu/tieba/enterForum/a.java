package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            bw bce = absThreadDataSupport.bce();
            if (bce.bdk()) {
                TiebaStatic.log(l.f(bce, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bce, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bce, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bce, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bce, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bce, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bce, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bce() != null) {
            if (absThreadDataSupport.bce().bdk()) {
                s.cbY().e(l.b(absThreadDataSupport.bce(), str));
            } else {
                s.cbY().e(l.a(absThreadDataSupport.bce(), str));
            }
        }
    }
}
