package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.p;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.i implements p {
    private CardForum klC;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.klC = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(cta() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(cta() + 0);
            }
            if (y.getCount(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.g gVar = new com.baidu.tieba.card.data.g();
                        gVar.forumAvatar = personalForum.avatar;
                        gVar.forumName = personalForum.forum_name;
                        gVar.forumId = com.baidu.adp.lib.f.b.toInt("" + personalForum.forum_id, -1);
                        gVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(gVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.p
    public int getPosition() {
        if (this.klC != null) {
            return this.klC.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.p
    public boolean csY() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pE(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.p
    public void pF(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean bMC() {
        if (y.getCount(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean BX(int i) {
        return i == 1;
    }
}
