package com.baidu.tieba.homepage.recommendfrs;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.f.b<Object, com.baidu.tbadk.mvc.d.b, com.baidu.tbadk.mvc.f.a<Object, com.baidu.tbadk.mvc.d.b>> {
    private static final Class<?>[] cBb = {com.baidu.tieba.homepage.recommendfrs.item.c.class, com.baidu.tieba.homepage.recommendfrs.item.g.class, com.baidu.tieba.homepage.recommendfrs.item.a.class};
    private static final int[] cBc = {w.j.recommend_frs_item_pic, w.j.recommend_frs_item_pics, w.j.recommend_frs_item_photo_live};

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        super(tbPageContext, cBb, cBc, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.f.b
    public int eU(int i) {
        Object item = getItem(i);
        if (item instanceof com.baidu.tieba.homepage.recommendfrs.data.e) {
            com.baidu.tieba.homepage.recommendfrs.data.e eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) item;
            if (eVar.akd() == 33) {
                return 2;
            }
            return eVar.getType() == 2 ? 1 : 0;
        }
        return 0;
    }

    public com.baidu.tieba.homepage.recommendfrs.data.e ajK() {
        com.baidu.tieba.homepage.recommendfrs.data.e eVar;
        for (int count = getCount() - 1; count >= 0; count--) {
            Object item = getItem(count);
            if ((item instanceof com.baidu.tieba.homepage.recommendfrs.data.e) && (eVar = (com.baidu.tieba.homepage.recommendfrs.data.e) item) != null) {
                return eVar;
            }
        }
        return null;
    }
}
