package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.j0.q0.w1.a;
import d.a.j0.q0.w1.d.d;
/* loaded from: classes4.dex */
public class GameSubCommentView {

    /* renamed from: a  reason: collision with root package name */
    public View f16298a;

    /* renamed from: b  reason: collision with root package name */
    public SpannableTextView f16299b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1469a f16300c;

    /* loaded from: classes4.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public GameSubCommentView f16301a;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.c());
            this.f16301a = gameSubCommentView;
        }

        public void b(d dVar) {
            this.f16301a.b(dVar);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f16302e;

        public a(d dVar) {
            this.f16302e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GameSubCommentView.this.f16300c != null) {
                GameSubCommentView.this.f16300c.c(this.f16302e);
            }
        }
    }

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.f16298a = inflate;
        SpannableTextView spannableTextView = (SpannableTextView) inflate.findViewById(R.id.sub_comment_tv);
        this.f16299b = spannableTextView;
        SkinManager.setViewTextColor(spannableTextView, R.color.CAM_X0106);
    }

    public void b(d dVar) {
        if (dVar == null || dVar.f58893h == null) {
            return;
        }
        this.f16299b.e(dVar);
        this.f16299b.setOnClickListener(new a(dVar));
    }

    public View c() {
        return this.f16298a;
    }

    public void d(a.InterfaceC1469a interfaceC1469a) {
        this.f16300c = interfaceC1469a;
        this.f16299b.setClickListener(interfaceC1469a);
    }
}
