package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes2.dex */
public class b extends g implements r {
    private CardForum eeA;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.eeA = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(ajR() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(ajR() + 0);
            }
            if (v.F(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.g.b.h("" + personalForum.forum_id, -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.eeA != null) {
            return this.eeA.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean ajP() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eD(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eE(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean UH() {
        if (v.F(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean oV(int i) {
        return i == 1;
    }
}
