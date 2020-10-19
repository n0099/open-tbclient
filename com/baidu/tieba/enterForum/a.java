package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
/* loaded from: classes22.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            bw bfG = absThreadDataSupport.bfG();
            if (bfG.bgN()) {
                TiebaStatic.log(l.f(bfG, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bfG, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bfG, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bfG, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bfG, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bfG, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bfG, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bfG() != null) {
            if (absThreadDataSupport.bfG().bgN()) {
                s.ciJ().e(l.b(absThreadDataSupport.bfG(), str));
            } else {
                s.ciJ().e(l.a(absThreadDataSupport.bfG(), str));
            }
        }
    }
}
