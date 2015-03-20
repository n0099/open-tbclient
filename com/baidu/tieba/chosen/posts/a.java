package com.baidu.tieba.chosen.posts;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import tbclient.HotThread.Pic;
import tbclient.HotThread.tinfo;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.mvc.j.b<tinfo, com.baidu.tbadk.mvc.e.c, com.baidu.tbadk.mvc.j.a<tinfo, com.baidu.tbadk.mvc.e.c>> {
    public a(TbPageContext<?> tbPageContext, Class<?>[] clsArr, int[] iArr, ViewEventCenter viewEventCenter) {
        super(tbPageContext, clsArr, iArr, viewEventCenter);
    }

    @Override // com.baidu.tbadk.mvc.j.b
    public int dS(int i) {
        tinfo item = getItem(i);
        if (item == null) {
            return -1;
        }
        if (item.pics != null) {
            for (Pic pic : item.pics) {
                if (pic != null && !StringUtils.isNull(pic.small_pic)) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
