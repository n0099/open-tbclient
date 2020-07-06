package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
/* loaded from: classes9.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            bu aPS = absThreadDataSupport.aPS();
            if (aPS.aQV()) {
                TiebaStatic.log(l.f(aPS, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aPS, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(aPS, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(aPS, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(aPS, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(aPS, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(aPS, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.aPS() != null) {
            if (absThreadDataSupport.aPS().aQV()) {
                s.bOB().e(l.b(absThreadDataSupport.aPS(), str));
            } else {
                s.bOB().e(l.a(absThreadDataSupport.aPS(), str));
            }
        }
    }
}
