package com.baidu.tieba.homepage.personalize.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.card.data.r;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.PersonalForum;
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.card.data.g implements r {
    private CardForum cKG;

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0088: IGET  (r6v1 java.lang.Long A[REMOVE]) = (r0v10 tbclient.Personalized.PersonalForum) tbclient.Personalized.PersonalForum.forum_id java.lang.Long)] */
    public void a(CardForum cardForum) {
        if (cardForum != null) {
            this.cKG = cardForum;
            this.mGroupTitle = cardForum.card_title;
            if (cardForum.position != null) {
                setYuelaouLocate(String.valueOf(VZ()) + cardForum.position.intValue());
            } else {
                setYuelaouLocate(String.valueOf(VZ()) + 0);
            }
            if (z.s(cardForum.forum_list) > 0) {
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

    @Override // com.baidu.tieba.card.data.r
    public int getPosition() {
        if (this.cKG != null) {
            return this.cKG.position.intValue();
        }
        return 0;
    }

    @Override // com.baidu.tieba.card.data.r
    public boolean VX() {
        return true;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dw(boolean z) {
        this.showTopDivider = z;
    }

    @Override // com.baidu.tieba.card.data.r
    public void dx(boolean z) {
        this.showBottomDivider = z;
    }

    public boolean LC() {
        if (z.s(getDataList()) > 0) {
            return true;
        }
        return false;
    }

    public static boolean kA(int i) {
        return i == 1;
    }
}
