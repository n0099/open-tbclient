package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class a {
    public static void a(View view, AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null) {
            bw bjZ = absThreadDataSupport.bjZ();
            if (bjZ.blg()) {
                TiebaStatic.log(l.f(bjZ, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bjZ, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bjZ, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bjZ, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bjZ, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bjZ, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bjZ, str));
            }
        }
    }

    public static void a(AbsThreadDataSupport absThreadDataSupport, String str) {
        if (absThreadDataSupport != null && absThreadDataSupport.bjZ() != null) {
            if (absThreadDataSupport.bjZ().blg()) {
                t.cor().e(l.b(absThreadDataSupport.bjZ(), str));
            } else {
                t.cor().e(l.a(absThreadDataSupport.bjZ(), str));
            }
        }
    }
}
