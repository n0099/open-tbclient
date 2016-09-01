package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.s;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.data.j implements s {
    private CardForum cGI;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0088: IGET  (r6v1 java.lang.Long A[REMOVE]) = (r0v10 tbclient.Personalized.PersonalForum) tbclient.Personalized.PersonalForum.forum_id java.lang.Long)] */
    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.cGI = cardForum;
            this.bbo = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(String.valueOf(NW()) + cardForum.position.intValue());
            } else {
                setYuelaouLocate(String.valueOf(NW()) + 0);
            }
            if (y.s(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.h.b.g(new StringBuilder().append(personalForum.forum_id).toString(), -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.s
    public int getPosition() {
        if (this.cGI != null) {
            return this.cGI.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.s
    public boolean NO() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.s
    public void ct(boolean z) {
        this.bbs = z;
    }

    public boolean pg() {
        if (y.s(Fu()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean ke(int i) {
        return i == 1;
    }

    public static boolean kf(int i) {
        return i == 2;
    }
}
