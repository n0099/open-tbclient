package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            bv aTN = absThreadDataSupport.aTN();
            if (aTN.aUR()) {
                TiebaStatic.log(l.f(aTN, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aTN, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(aTN, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(aTN, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(aTN, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aTN, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(aTN, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aTN() != null) {
            if (absThreadDataSupport.aTN().aUR()) {
                s.bRL().e(l.b(absThreadDataSupport.aTN(), str));
            } else {
                s.bRL().e(l.a(absThreadDataSupport.aTN(), str));
            }
        }
    }
}
