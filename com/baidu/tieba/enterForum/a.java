package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bmn() != null) {
            by bmn = aVar.bmn();
            if (bmn.bnv()) {
                TiebaStatic.log(l.f(bmn, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bmn, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(bmn, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(bmn, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(bmn, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(bmn, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(bmn, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bmn() != null) {
            if (aVar.bmn().bnv()) {
                t.csg().e(l.b(aVar.bmn(), str));
            } else {
                t.csg().e(l.a(aVar.bmn(), str));
            }
        }
    }
}
