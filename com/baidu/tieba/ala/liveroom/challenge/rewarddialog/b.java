package com.baidu.tieba.ala.liveroom.challenge.rewarddialog;

import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b {
    public static com.baidu.live.tieba.pb.interactionpopupwindow.c a(TbPageContext tbPageContext, Object obj) {
        if (tbPageContext == null || tbPageContext.getPageActivity() == null || obj == null || !(obj instanceof AlaChallengeRewardData)) {
            return null;
        }
        return new a(tbPageContext, (AlaChallengeRewardData) obj);
    }
}
