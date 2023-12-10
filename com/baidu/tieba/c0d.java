package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.ForumBookInfo;
/* loaded from: classes5.dex */
public class c0d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ForumBookInfo forumBookInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, forumBookInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "book_id", forumBookInfo.book_id);
            ltc.a(jSONObject, PaymentConfirmActivityConfig.BOOK_TYPE, forumBookInfo.book_type);
            ltc.a(jSONObject, "book_title", forumBookInfo.book_title);
            ltc.a(jSONObject, "book_cover", forumBookInfo.book_cover);
            ltc.a(jSONObject, NotificationCompat.CarExtender.KEY_AUTHOR, forumBookInfo.author);
            ltc.a(jSONObject, "forum_pic", forumBookInfo.forum_pic);
            ltc.a(jSONObject, "show_chapter_id", forumBookInfo.show_chapter_id);
            ltc.a(jSONObject, "show_chapter_no", forumBookInfo.show_chapter_no);
            ltc.a(jSONObject, "show_chapter_title", forumBookInfo.show_chapter_title);
            ltc.a(jSONObject, "history_page_id", forumBookInfo.history_page_id);
            ltc.a(jSONObject, "history_paragraph_id", forumBookInfo.history_paragraph_id);
            ltc.a(jSONObject, "history_word_id", forumBookInfo.history_word_id);
            ltc.a(jSONObject, "history_percent", forumBookInfo.history_percent);
            ltc.a(jSONObject, "show_page_id", forumBookInfo.show_page_id);
            ltc.a(jSONObject, "show_paragraph_id", forumBookInfo.show_paragraph_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
