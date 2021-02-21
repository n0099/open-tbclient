package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
/* loaded from: classes2.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bln() != null) {
            cb bln = aVar.bln();
            if (bln.bmv()) {
                TiebaStatic.log(m.f(bln, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(m.d(bln, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(m.c(bln, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(m.c(bln, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(m.g(bln, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(m.d(bln, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(m.e(bln, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.bln() != null) {
            if (aVar.bln().bmv()) {
                t.csB().e(m.b(aVar.bln(), str));
            } else {
                t.csB().e(m.a(aVar.bln(), str));
            }
        }
    }
}
