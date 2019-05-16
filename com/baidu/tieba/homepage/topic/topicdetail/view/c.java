package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.widget.EditText;
import com.baidu.tbadk.editortools.k;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends k {
    private EditText csG;

    public c(Context context) {
        super(context, (String) null, 29);
        this.crx = false;
        this.crw = 3;
        this.cqE = new TopicDetaiInputContainer(context);
        this.csG = ((TopicDetaiInputContainer) this.cqE).getInputView();
        ((TopicDetaiInputContainer) this.cqE).setHint(context.getString(R.string.say_your_point));
        this.cry = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText getInputView() {
        return this.csG;
    }
}
