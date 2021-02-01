package com.baidu.tieba.ala.alasquare.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.a;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.g;
import com.baidu.tieba.ala.alasquare.widget.g;
/* loaded from: classes10.dex */
public class AlaSquareVideoAdapter extends a<g, SquareVideoViewHolder> {
    private int gyd;
    private boolean gyl;
    private boolean gyo;
    private boolean gyp;
    private g.b gyt;
    private TbPageContext<?> mPageContext;
    private int mTabIndex;

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Q */
    public SquareVideoViewHolder e(ViewGroup viewGroup) {
        com.baidu.tieba.ala.alasquare.widget.g gVar = new com.baidu.tieba.ala.alasquare.widget.g(this.mPageContext);
        gVar.mP(this.gyo);
        gVar.mQ(this.gyp);
        gVar.mO(this.gyl);
        gVar.a(this.gyt);
        return new SquareVideoViewHolder(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.ala.alasquare.a.g gVar, SquareVideoViewHolder squareVideoViewHolder) {
        com.baidu.tieba.ala.alasquare.widget.g gVar2;
        if (squareVideoViewHolder == null || (gVar2 = squareVideoViewHolder.gyu) == null || gVar2.getView() == null) {
            return null;
        }
        if (gVar != null) {
            gVar.locate = i + 1;
        }
        gVar2.a(gVar);
        com.baidu.tieba.ala.alasquare.b.a.bRX().e(gVar.az(bQX(), false));
        a(gVar);
        if (i == this.gyd) {
            gVar2.getView().setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.list_anim));
        }
        return gVar2.getView();
    }

    private String bQX() {
        if (this.mTabIndex == 2) {
            return "c12127";
        }
        if (this.mTabIndex == 1) {
            return "c12479";
        }
        return null;
    }

    /* loaded from: classes10.dex */
    public class SquareVideoViewHolder extends TypeAdapter.ViewHolder {
        public com.baidu.tieba.ala.alasquare.widget.g gyu;

        public SquareVideoViewHolder(com.baidu.tieba.ala.alasquare.widget.g gVar) {
            super(gVar.getView());
            this.gyu = gVar;
        }
    }

    private void a(com.baidu.tieba.ala.alasquare.a.g gVar) {
        if (gVar != null && gVar.gyA != null && TextUtils.equals("c12479", bQX())) {
            ar arVar = new ar("c12461");
            if (StringUtils.isNull(gVar.gyA.mRecomSource)) {
                arVar.dR("obj_source", "0");
            } else {
                arVar.dR("obj_source", "1");
            }
            if (StringUtils.isNull(gVar.gyA.mRecomAbTag)) {
                arVar.dR("obj_locate", "0");
            } else {
                arVar.dR("obj_locate", "1");
            }
            arVar.dR("obj_type", "1");
            com.baidu.tieba.ala.alasquare.b.a.bRX().e(arVar);
        }
    }
}
