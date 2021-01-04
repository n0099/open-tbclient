package com.baidu.tieba.enterForum;

import android.view.View;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
/* loaded from: classes2.dex */
public class a {
    public static void a(View view, com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.boO() != null) {
            bz boO = aVar.boO();
            if (boO.bpV()) {
                TiebaStatic.log(l.f(boO, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(boO, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(boO, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(boO, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(boO, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(boO, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(boO, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.boO() != null) {
            if (aVar.boO().bpV()) {
                s.cva().e(l.b(aVar.boO(), str));
            } else {
                s.cva().e(l.a(aVar.boO(), str));
            }
        }
    }
}
