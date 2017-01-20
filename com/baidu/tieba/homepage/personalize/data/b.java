package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.card.data.i;
import com.baidu.tieba.card.data.t;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class b extends i implements t {
    private CardForum cyV;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0088: IGET  (r6v1 java.lang.Long A[REMOVE]) = (r0v10 tbclient.Personalized.PersonalForum) tbclient.Personalized.PersonalForum.forum_id java.lang.Long)] */
    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.cyV = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(String.valueOf(RN()) + cardForum.position.intValue());
            } else {
                setYuelaouLocate(String.valueOf(RN()) + 0);
            }
            if (w.r(cardForum.forum_list) > 0) {
                for (PersonalForum personalForum : cardForum.forum_list) {
                    if (personalForum != null && !TextUtils.isEmpty(personalForum.forum_name) && personalForum.forum_id.longValue() > 0) {
                        com.baidu.tieba.card.data.e eVar = new com.baidu.tieba.card.data.e();
                        eVar.forumAvatar = personalForum.avatar;
                        eVar.forumName = personalForum.forum_name;
                        eVar.forumId = com.baidu.adp.lib.g.b.g(new StringBuilder().append(personalForum.forum_id).toString(), -1);
                        eVar.isLiked = personalForum.is_like.intValue() == 1;
                        b(eVar);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.card.data.t
    public int getPosition() {
        if (this.cyV != null) {
            return this.cyV.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.t
    public boolean RE() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cP(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.t
    public void cQ(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean pc() {
        if (w.r(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean kp(int i) {
        return i == 1;
    }
}
