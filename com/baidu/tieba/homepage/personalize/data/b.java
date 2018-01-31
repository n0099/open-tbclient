package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.data.g implements r {
    private CardForum egk;

    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.egk = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(akZ() + cardForum.position.intValue());
            } else {
                setYuelaouLocate(akZ() + 0);
            }
            if (v.D(cardForum.forum_list) > 0) {
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
        if (this.egk != null) {
            return this.egk.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean akX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eJ(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void eK(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean Ux() {
        if (v.D(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean oO(int i) {
        return i == 1;
    }
}
