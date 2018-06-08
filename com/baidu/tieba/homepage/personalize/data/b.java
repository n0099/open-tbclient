package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.g implements p {
    private CardForum dRy;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.dRy = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(ajy() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(ajy() + 0);
            }
            if (w.y(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.g.b.g("" + personalForum.forum_id, -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.dRy != null) {
            return this.dRy.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean ajw() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eA(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void eB(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean isValidate() {
        if (w.y(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean mz(int i) {
        return i == 1;
    }
}
