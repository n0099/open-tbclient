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
        if (aVar != null && aVar.boP() != null) {
            bz boP = aVar.boP();
            if (boP.bpW()) {
                TiebaStatic.log(l.f(boP, str));
                return;
            }
            int id = view.getId();
            if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(boP, str));
            } else if (id == R.id.user_avatar) {
                TiebaStatic.log(l.c(boP, str));
            } else if (id == R.id.user_name) {
                TiebaStatic.log(l.c(boP, str));
            } else if (id == R.id.forum_name_text) {
                TiebaStatic.log(l.g(boP, str));
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(l.d(boP, str));
            } else if (view instanceof TbImageView) {
                TiebaStatic.log(l.e(boP, str));
            }
        }
    }

    public static void a(com.baidu.tbadk.core.data.a aVar, String str) {
        if (aVar != null && aVar.boP() != null) {
            if (aVar.boP().bpW()) {
                s.cvb().e(l.b(aVar.boP(), str));
            } else {
                s.cvb().e(l.a(aVar.boP(), str));
            }
        }
    }
}
